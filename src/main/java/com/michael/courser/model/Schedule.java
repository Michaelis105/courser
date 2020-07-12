package com.michael.courser.model;

import java.util.List;

public class Schedule {

    int id;
    Integer studentId;
    List<Class> classes;

    public Schedule(int id, Integer studentId, List<Class> classes) {
        this.id = id;
        this.studentId = studentId;
        this.classes = classes;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public List<Class> getClasses() { return classes; }

    public void setClasses(List<Class> classes) { this.classes = classes; }

}
