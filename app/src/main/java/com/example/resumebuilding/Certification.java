package com.example.resumebuilding;



// Certification.java
public class Certification {
    private String name;
    private String desc;
    private String year;

    // Default constructor (required by Firestore)
    public Certification() {
    }

    public Certification(String desc, String name, String year) {
        this.name = name;
        this.desc = desc;
        this.year = year;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
