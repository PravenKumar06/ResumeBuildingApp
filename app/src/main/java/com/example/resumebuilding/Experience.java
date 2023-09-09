package com.example.resumebuilding;

public class Experience {
    private String name;
    private String comp;
    private String dur;

    public Experience() {
        // Empty constructor for Firebase
    }

    public Experience(String name, String comp, String dur) {
        this.name = name;
        this.comp = comp;
        this.dur = dur;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComp() {
        return comp;
    }

    public void setComp(String comp) {
        this.comp = comp;
    }

    public String getDur() {
        return dur;
    }

    public void setDur(String dur) {
        this.dur = dur;
    }
}
