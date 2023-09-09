package com.example.resumebuilding;

// Project.java
public class Project {
    private String name;
    private String desc;
    private String dur;

    // Default constructor (required by Firestore)
    public Project() {
    }

    public Project(String name, String desc, String dur) {
        this.name = name;
        this.desc = desc;
        this.dur = dur;
    }

    // Getters and Setters (required for accessing fields)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }
}
