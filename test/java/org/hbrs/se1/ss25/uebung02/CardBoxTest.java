package org.hbrs.se1.ss25.uebung02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardBoxTest {

    PersonCard EndUser1;
    PersonCard EndUser2;
    PersonCard Developer1;
    PersonCard Developer2;

    CardBox cardBox;

    @BeforeEach
    void setUp() {
        cardBox = CardBox.getInstance();
        EndUser1 = new EndUserCard("Vorname1", "Nachname1", true);
        EndUser2 = new EndUserCard("Vorname2", "Nachname2", false);
        Developer1 = new DeveloperCards("Vorname3", "Nachname3", true);
        Developer2 = new DeveloperCards("Vorname4", "Nachname4", false);
    }

    @Test
    public void testAddPersonCard() throws CardBoxException {
        cardBox.addPersonCard(EndUser1);
        cardBox.addPersonCard(Developer1);
        assertEquals(2, cardBox.size());
    }

    @Test
    public void testThrowException() throws CardBoxException {
        cardBox.addPersonCard(EndUser1);
        assertThrows(CardBoxException.class, () -> cardBox.addPersonCard(EndUser1));
    }

    @Test
    public void testDeletePersonCard() throws CardBoxException {
        cardBox.addPersonCard(Developer1);
        String result = cardBox.deletePersonCard(Developer1);
        assertEquals("Person gelöscht.", result);
    }

    @Test
    public void testDeletePersonCardNotFound() {
        String result = cardBox.deletePersonCard(Developer1);
        assertEquals("Keine Person mit ID "+ Developer1.getId() +" vorhanden.", result);
        System.out.println(result);
    }

    @Test
    public void testShowContent() throws CardBoxException {
        cardBox.addPersonCard(Developer2);
        cardBox.addPersonCard(EndUser2);
        /* Sollte so aussehen:
         * ID = 3011, Vorname = Vorname4, Nachname = Nachname4, hasEnoughCoffee = false
         * ID = 3009, Vorname = Vorname2, Nachname = Nachname2, isHungry = false
        */
        assertEquals(2, cardBox.size());
    }
}
