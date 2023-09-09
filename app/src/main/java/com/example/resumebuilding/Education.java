package com.example.resumebuilding;

public class Education {
    private String university;
    private String degree;
    private String cgpa;
    private String year;

    public Education() {
        // Empty constructor for Firebase
    }

    public Education(String university, String degree, String cgpa, String year) {
        this.university = university;
        this.degree = degree;
        this.cgpa = cgpa;
        this.year = year;
    }

    // Getters and setters
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCGPA() {
        return cgpa;
    }

    public void setCGPA(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
