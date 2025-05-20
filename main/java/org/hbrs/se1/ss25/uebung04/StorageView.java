package org.hbrs.se1.ss25.uebung04;


import java.util.ArrayList;

public class StorageView {
    public static void showUserStory(ArrayList<UserStory> UserList) {
            if (UserList.isEmpty()) {
                return;
            }
            for (UserStory story : UserList) {
                System.out.println(story);
            }
    }
    public static void showTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            return;
        }
        for (Task task : taskList) {
            System.out.println(task);
        }
    }
}
