package org.hbrs.se1.ss25.uebung02;

import org.hbrs.se1.ss25.uebung03.CardboxStorageException;

import java.io.*;
import java.util.ArrayList;

public class CardBox {

    ArrayList<PersonCard> personList = new ArrayList<>();
    private static CardBox instance;

    private CardBox() {
    }

    public static CardBox getInstance() {
        if (instance == null) {
            instance = new CardBox();
        }
        return instance;
    }

    public void addPersonCard(PersonCard person) throws CardBoxException {
        if (person == null) {
            throw new CardBoxException("Person object is null");
        }
        for (PersonCard personCard : personList) {
            if (personCard.getId() == person.getId()) {
                throw new CardBoxException("Das Cardbox-Objekt mit der ID " + person.getId() + " ist bereits vorhanden.");
            }
        }
        personList.add(person);
    }

    public String deletePersonCard(PersonCard person) {
        if (person == null) {
            return "Person object is null";
        }
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getId() == person.getId()) {
                personList.remove(i);
                return "Person gelöscht.";
            }
        }
        return "Keine Person mit ID " + person.getId() + " vorhanden.";
    }



    public int size() {
        return personList.size();
    }
    public ArrayList<PersonCard> getPersonList() {
        return personList;
    }

    //Übung 03
    public void save() throws CardboxStorageException {
        try {
            FileOutputStream fileO = new FileOutputStream("cardbox.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fileO);
            oos.writeObject(getPersonList());
        } catch (IOException e) {
            throw new CardboxStorageException("File not found", e);
        }
    }
    @SuppressWarnings("unchecked")
    public void load() throws CardboxStorageException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("cardbox.ser"))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> tempList) {
                for (Object item : tempList) {
                    if (!(item instanceof PersonCard)) {
                        throw new CardboxStorageException("Die gespeicherten Daten enthalten ungültige Objekte.");
                    }
                }
                personList = (ArrayList<PersonCard>) obj;
            } else {
                throw new CardboxStorageException("Die Datei enthält keine gültige ArrayList.");
            }
        } catch (Exception e) {
            throw new CardboxStorageException("Fehler beim Laden der CardBox", e);
        }
    }
}
