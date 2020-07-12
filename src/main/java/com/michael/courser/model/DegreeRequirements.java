package com.michael.courser.model;

import java.util.List;

public class DegreeRequirements {
    int id;
    String subject;
    String degreeLevel;
    List<Integer> courseRequirements;

    DegreeRequirements(int id, String subject, String degreeLevel, List<Integer> courseRequirements) {
        this.id = id;
        this.subject = subject;
        this.degreeLevel = degreeLevel;
        this.courseRequirements = courseRequirements;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public String getDegreeLevel() { return degreeLevel; }

    public void setDegreeLevel(String degreeLevel) { this.degreeLevel = degreeLevel; }

    public List<Integer> getCourseRequirements() { return courseRequirements; }

    public void setCourseRequirements(List<Integer> courseRequirements) { this.courseRequirements = courseRequirements; }


}
