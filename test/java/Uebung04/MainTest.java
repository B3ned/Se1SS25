package Uebung04;
import org.hbrs.se1.ss25.uebung04.*;

import org.junit.jupiter.api.*;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Storage container;

    @BeforeEach
    void setup() {
        container = Storage.getInstance();
        File f = new File("TaskSpeicher.ser");
        File z = new File("UserStorySpeicher.ser");
        if(f.exists())
            f.delete();
        if(z.exists())
            z.delete();
    }

    // E1: gültige UserStory
    @Test
    void testE1_validUserStory() throws Exception {
        Main.parseCommand("story 1 \"Als Nutzer möchte ich etwas tun\" Moscow");
        assertEquals(1, container.getUserList().size());
    }

    // E2: fehlende ID
    @Test
    void testE2_storyMissingId() throws Exception {
        assertThrows(Exception.class, () -> {Main.parseCommand("story \"Als Nutzer möchte ich etwas tun\" Moscow");});
    }

    // E3: keine Quotes
    @Test
    void testE3_storyWithoutQuotes() throws Exception {
        assertThrows(Exception.class, () -> {
            Main.parseCommand("story 1 Als Nutzer möchte ich etwas tun Moscow");
        });
    }



    // E4: gültige Task
    @Test
    void testE4_validTask() throws Exception {
        Main.parseCommand("task 42 \"Refactoring durchführen\"");
        assertEquals(1, container.getTaskList().size());
    }

    // E5: Task ohne ID
    @Test
    void testE5_taskMissingId() throws Exception {
        assertThrows(Exception.class, () -> {
            Main.parseCommand("task \"Refactoring durchführen\"");
        });
    }

    // E6: Task ohne Quotes
    @Test
    void testE6_taskWithoutQuotes() throws Exception {
        assertThrows(Exception.class, () -> {
            Main.parseCommand("task 42 Refactoring durchführen");
        });

    }



}
