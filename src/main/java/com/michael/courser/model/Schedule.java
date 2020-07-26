package com.michael.courser.model;

import java.util.List;

public class Schedule {

    int id;
    Integer studentId;
    List<Class> classes;
    List<Course> courses;

    public Schedule(int id, Integer studentId, List<Course> courses, List<Class> classes) {
        this.id = id;
        this.studentId = studentId;
        this.courses = courses;
        this.classes = classes;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public List<Course> getCourses() { return courses; }

    public void setCourses(List<Course> courses) { this.courses = courses; }

    public List<Class> getClasses() { return classes; }

    public void setClasses(List<Class> classes) { this.classes = classes; }

}
