package org.hbrs.se1.ss25.uebung04;

import java.io.Serializable;

public class Task implements Serializable {
    private String task;
    private int id;
    public Task(int id,String task) {
        this.task = task;
        this.id = id;
    }
    public String getTask() {
        return task;
    }
    public int getId() {
        return id;
    }
    public void setTask(String task) {
        this.task = task;
    }

    public String toString() {
        return "" + id + " " + task;
    }
}
