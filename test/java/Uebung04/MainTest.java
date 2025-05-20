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
        File f = new File("/home/bene/git/codesSS2025/main/java/org/hbrs/se1/ss25/uebung04/TaskSpeicher.ser");
        File z = new File("/home/bene/git/codesSS2025/main/java/org/hbrs/se1/ss25/uebung04/UserStorySpeicher.ser");
        if(f.exists())
            f.delete();
        if(z.exists())
            z.delete();

        container.clear(); // Methode hinzufügen, die UserStory- und Task-Listen leert
    }

    // E1: gültige UserStory
    @Test
    void testE1_validUserStory() throws Exception {
        Main.scanning("story 1 \"Als Nutzer möchte ich etwas tun\" Moscow");
        assertEquals(1, container.getUserList().size());
    }

    // E2: fehlende ID
    @Test
    void testE2_storyMissingId() throws Exception {
        Main.scanning("story \"Als Nutzer möchte ich etwas tun\" Moscow", container);
        assertEquals(0, container.getUserList().size());
    }

    // E3: keine Quotes
    @Test
    void testE3_storyWithoutQuotes() throws Exception {
        Main.scanning("story 1 Als Nutzer möchte ich etwas tun Moscow", container);
        assertEquals(0, container.getUserList().size());
    }

    // E4: gültige Task
    @Test
    void testE4_validTask() throws Exception {
        Main.processInput("task 42 \"Refactoring durchführen\"", container);
        assertEquals(1, container.getTaskList().size());
    }

    // E5: Task ohne ID
    @Test
    void testE5_taskMissingId() throws Exception {
        Main.processInput("task \"Refactoring durchführen\"", container);
        assertEquals(0, container.getTaskList().size());
    }

    // E6: Task ohne Quotes
    @Test
    void testE6_taskWithoutQuotes() throws Exception {
        Main.processInput("task 42 Refactoring durchführen", container);
        assertEquals(0, container.getTaskList().size());
    }

    // E7: stories anzeigen (Ausgabe wird nicht geprüft)
    @Test
    void testE7_storiesCommand() throws Exception {
        Main.processInput("stories", container);
    }

    // E8: tasks anzeigen (Ausgabe wird nicht geprüft)
    @Test
    void testE8_tasksCommand() throws Exception {
        Main.processInput("tasks", container);
    }

    // E9: save
    @Test
    void testE9_saveCommand() throws Exception {
        Main.processInput("save", container);
    }

    // E10: load
    @Test
    void testE10_loadCommand() throws Exception {
        Main.processInput("load", container);
    }

    // E11: exit
    @Test
    void testE11_exitCommand() throws Exception {
        Main.processInput("exit", container);
    }

    // E12: ungültiger Befehl
    @Test
    void testE12_invalidCommand() throws Exception {
        Main.processInput("foo", container);
    }
}
