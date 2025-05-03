package org.hbrs.se1.ss25.uebung02;
import org.hbrs.se1.ss25.uebung02.*;
import org.hbrs.se1.ss25.uebung03.*;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CardBoxTestZwei {
    private final String FILENAME = "cardbox.ser";
    CardBox box;
    @BeforeEach
    public void setup() {
        CardBox.getInstance().getPersonList().clear();
        deleteFile();
    }

    @AfterEach
    public void cleanup() {
        deleteFile();
    }

    private void deleteFile() {
        File file = new File(FILENAME);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testSaveAndLoad() throws Exception {
        CardBox box = CardBox.getInstance();
        DeveloperCards p1 = new DeveloperCards("Anna","Meister",true);
        EndUserCard p2 = new EndUserCard("Max","Muster",true);

        box.addPersonCard(p1);
        box.addPersonCard(p2);
        box.save();

        box.getPersonList().clear();
        assertEquals(0, box.size());

        box.load();
        List<PersonCard> loadedList = box.getPersonList();
        assertEquals(2, loadedList.size());
        assertEquals(3000, loadedList.get(0).getId());
        assertEquals(3001, loadedList.get(1).getId());
        assertInstanceOf(DeveloperCards.class, loadedList.get(0));
        assertInstanceOf(EndUserCard.class, loadedList.get(1));
    }

    @Test
    public void testLoadFromMissingFileThrowsException() {
        CardBox box = CardBox.getInstance();
        Exception exception = assertThrows(CardboxStorageException.class, box::load);
        assertEquals("Fehler beim Laden der CardBox", exception.getMessage());
    }

    @Test
    public void testLoadWithInvalidDataThrowsException() throws Exception {
        try (var out = new java.io.ObjectOutputStream(new java.io.FileOutputStream(FILENAME))) {
            out.writeObject("Kein gültiges Objekt");
        }

        CardBox box = CardBox.getInstance();
        Exception exception = assertThrows(CardboxStorageException.class, box::load);
        assertEquals("Fehler beim Laden der CardBox", exception.getMessage());
    }

    @Test
    public void testLoadWithInvalidObjectsInArrayListThrowsException() throws Exception {
        try (var out = new java.io.ObjectOutputStream(new java.io.FileOutputStream(FILENAME))) {
            ArrayList<Object> test = new ArrayList<>();
            test.add(new DeveloperCards("Dings","Da",false));
            test.add(3001);
            out.writeObject(test);
        }

        CardBox box = CardBox.getInstance();
        Exception exception = assertThrows(CardboxStorageException.class, box::load);
        assertEquals("Fehler beim Laden der CardBox", exception.getMessage());
    }
}