package org.hbrs.se1.ss25.uebung04;

import java.io.*;
import java.util.ArrayList;

public class Storage {

    private ArrayList<UserStory> userList = new ArrayList<>();
    private ArrayList<Task> taskList = new ArrayList<>();
    private static Storage instance;

    private Storage() {
    }
    //Singleton Pattern
    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void addUserStory(UserStory story) throws CardBoxException {
        if (story == null) {
            throw new CardBoxException("Person object is null");
        }
        for (UserStory tmp : userList) {
            if (tmp.getId() == story.getId()) {
                throw new CardBoxException("Das UserStory-Objekt mit der ID " + story.getId() + " ist bereits vorhanden.");
            }
        }
        userList.add(story);
    }

    public void addTask(Task task) throws CardBoxException {
        if (task == null) {
            throw new CardBoxException("Task object is null");
        }
        for (Task tmp : taskList) {
            if (tmp.getId() == task.getId()) {
                throw new CardBoxException("Das Task-Objekt mit der ID " + task.getId() + " ist bereits vorhanden.");
            }
        }
        taskList.add(task);
    }


    public String deletePersonCard(PersonCard person) {
        if (person == null) {
            return "Person object is null";
        }
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == person.getId()) {
                userList.remove(i);
                return "Person gelöscht.";
            }
        }
        return "Keine Person mit ID " + person.getId() + " vorhanden.";
    }

    public void save() throws CardboxStorageException {
        saveUserStory();
        saveTask();
    }

    public void saveUserStory() throws CardboxStorageException {
        try {
            FileOutputStream fileO = new FileOutputStream("/home/bene/git/codesSS2025/main/java/org/hbrs/se1/ss25/uebung04/UserStorySpeicher.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fileO);
            oos.writeObject(getUserList());
        } catch (IOException e) {
            throw new CardboxStorageException("File not found", e);
        }
    }

    public void saveTask() throws CardboxStorageException {
        try {
            FileOutputStream fileO = new FileOutputStream("/home/bene/git/codesSS2025/main/java/org/hbrs/se1/ss25/uebung04/TaskSpeicher.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fileO);
            oos.writeObject(getTaskList());
        } catch (IOException e) {
            throw new CardboxStorageException("File not found", e);
        }
    }
    public void load() throws CardboxStorageException {
        loadTask();
        loadUserStory();
    }
    @SuppressWarnings("unchecked")
    public void loadUserStory() throws CardboxStorageException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/bene/git/codesSS2025/main/java/org/hbrs/se1/ss25/uebung04/UserStorySpeicher.ser"))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> tempList) {
                for (Object item : tempList) {
                    if (!(item instanceof UserStory)) {
                        throw new CardboxStorageException("Die gespeicherten Daten enthalten ungültige Objekte.");
                    }
                }
                this.userList = (ArrayList<UserStory>) obj;
            } else {
                throw new CardboxStorageException("Die Datei enthält keine gültige ArrayList.");
            }
        } catch (Exception e) {
            throw new CardboxStorageException("Fehler beim Laden der CardBox", e);
        }
    }


    @SuppressWarnings("unchecked")
    public void loadTask() throws CardboxStorageException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/home/bene/git/codesSS2025/main/java/org/hbrs/se1/ss25/uebung04/TaskSpeicher.ser"))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?> tempList) {
                for (Object item : tempList) {
                    if (!(item instanceof Task)) {
                        throw new CardboxStorageException("Die gespeicherten Daten enthalten ungültige Objekte.");
                    }
                }
                this.taskList = (ArrayList<Task>) obj;
            } else {
                throw new CardboxStorageException("Die Datei enthält keine gültige ArrayList.");
            }
        } catch (Exception e) {
            throw new CardboxStorageException("Fehler beim Laden der CardBox", e);
        }
    }

    //getter und setter
    public ArrayList<UserStory> getUserList() {
        return userList;
    }
    public ArrayList<Task> getTaskList() {
        return taskList;
    }
    public int size() {
        return userList.size();
    }

    public void clear() {

    }
}
