package org.hbrs.se1.ss25.uebung04;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws CardBoxException, CardboxStorageException {
        scanning();
    }
    public static void scanning() throws CardBoxException, CardboxStorageException {
        Storage container = Storage.getInstance();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            UserStory story;
            Task task;
            int start = 0;
            int end = 0;
            String inQuotes = null;

            System.out.print(">");
            String input = scanner.nextLine();
            String[] split = input.split(" ", 2);
            String rolle = split[0];
            String idStorymaybemoscow;
            String idmaybemoscow = "";
            switch (rolle) {
                case "story":
                    idStorymaybemoscow = split[1];
                    start = idStorymaybemoscow.indexOf('"');
                    end = idStorymaybemoscow.indexOf('"', start + 1);
                    if (start != -1 && end != -1) {
                        inQuotes = idStorymaybemoscow.substring(start + 1, end);
                        idmaybemoscow = idStorymaybemoscow.substring(0, start) + idStorymaybemoscow.substring(end + 1);
                    }
                    if (inQuotes == null) {
                        System.out.println("Keine gültige UserStory");
                        continue;
                    }
                    split = idmaybemoscow.split(" ");
                    story = new UserStory(Integer.parseInt(split[0]),inQuotes,split[2]);
                    container.addUserStory(story);
                    StorageView.showUserStory(container.getUserList());
                    break;
                case "task":
                    idStorymaybemoscow = split[1];
                    String id = "";
                    start = idStorymaybemoscow.indexOf('"');
                    end = idStorymaybemoscow.indexOf('"', start + 1);
                    if (start != -1 && end != -1) {
                        inQuotes = idStorymaybemoscow.substring(start + 1, end);
                        id = (idStorymaybemoscow.substring(0, start) + idStorymaybemoscow.substring(end + 1)).trim();
                    }
                    if (inQuotes == null) {
                        System.out.println("Keine gültige Task");
                        continue;
                    }
                    task = new Task(Integer.parseInt(id),inQuotes);
                    container.addTask(task);
                    break;
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
                case "exit":
                    return;
            }
        }
    }
}
