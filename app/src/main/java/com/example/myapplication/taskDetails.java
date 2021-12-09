package com.example.myapplication;

public class taskDetails {

    String name;
    String task;
    String location;

    public taskDetails(String name, String task, String location) {
        this.name = name;
        this.task = task;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getTask() {

        return task;
    }

}
