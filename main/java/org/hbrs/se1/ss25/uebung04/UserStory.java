package org.hbrs.se1.ss25.uebung04;

import java.io.Serializable;

public class UserStory implements Serializable {
    private int id;
    private String story;
    private String moscow;
    private Task task;

    public UserStory(int id, String story, String mos) {
        this.id = id;
        this.story = story;
        this.moscow = mos;
    }
    public int getId() {
        return id;
    }
    public String getStory() {
        return story;
    }
    public String getMoscow() {
        return moscow;
    }

    public String toString() {
        return "" + id + " " + story + " " + moscow;
    }

}
