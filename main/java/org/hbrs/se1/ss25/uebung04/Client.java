package org.hbrs.se1.ss25.uebung04;


public class Client {
    public static void main(String[] args) throws CardBoxException, CardboxStorageException {
        load();
    }
    public static void save() throws CardBoxException,  CardboxStorageException {
        Storage Container = Storage.getInstance();
        UserStory story = new UserStory(1,"Die erste UserStory","should-have");
        UserStory story1 = new UserStory(2,"zwei","should-have");
        Task task = new Task(1,"asijasf");

        Container.addUserStory(story);
        Container.addUserStory(story1);
        Container.addTask(task);
        StorageView.showUserStory(Container.getUserList());
        StorageView.showTask(Container.getTaskList());
        Container.save();
    }
    public static void load() throws CardboxStorageException {
        Storage Container = Storage.getInstance();
        Container.load();
        StorageView.showUserStory(Container.getUserList());
        StorageView.showTask(Container.getTaskList());
    }


}
