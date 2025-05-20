package org.hbrs.se1.ss25.uebung04;

import org.hbrs.se1.ss25.uebung04.*;
import java.util.Scanner;


public class Main {
    private static final Storage container = Storage.getInstance();
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print(">");
            String input = scanner.nextLine();
            parseCommand(input);
        }

    }

    private static String[] refactorString(String input) throws Exception {
        int space = input.indexOf(32);
        String rolle = space == -1? input : input.substring(0,space);
        String rest = space == -1? "" : input.substring(space+1).trim();
        String[] tmp = new String[2];
        tmp[0] = rolle;
        tmp[1] = rest;
        return tmp;
    }
    public static void parseCommand(String input) throws Exception {
        String[] s = refactorString(input);
        String rolle = s[0];
        String rest = s[1];
        switch (rolle) {
            case "stories":
                System.out.println("Die folgenden User Stories sind im System gespeichert:");
                StorageView.showUserStory(container.getUserList());
                break;
            case "tasks":
                System.out.println("Die folgenden Tasks sind im System gespeichert:");
                StorageView.showTask(container.getTaskList());
                break;
            case "save":
                container.save();
                break;
            case "load":
                container.load();
                break;
            case "story":
                parseStory(rest);
                break;
            case "task":
                parseTask(rest);
        }

    }

    public static void parseTask(String rest) throws Exception {
        String inQuotes = null;
        int start = rest.indexOf('"');
        int end = rest.indexOf('"', start + 1);
        if (start == -1 || end == -1) {
            throw new Exception("Ungültige Task");
        }
        inQuotes = rest.substring(start + 1, end);
        //id kriegt task 42
        String id = rest.substring(0, start);
        Task task = new Task(Integer.parseInt(id.trim()),inQuotes);
        container.addTask(task);
    }

    public static void parseStory(String rest) throws Exception {
        String inQuotes = null;
        int start = rest.indexOf('"');
        int end = rest.indexOf('"', start + 1);
        if (start == -1 || end == -1) {
            throw new Exception("Ungültiger UserStory");
        }
        inQuotes = rest.substring(start + 1, end);
        String id = rest.substring(0, start);
        if(id.isEmpty())
            throw new Exception("Keine ID vorhanden");
        String moscow = rest.substring(end+1);

        UserStory story = new UserStory(Integer.parseInt(id.trim()),inQuotes,moscow);
        container.addUserStory(story);
    }

}
