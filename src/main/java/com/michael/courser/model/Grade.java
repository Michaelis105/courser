package com.michael.courser.model;

public class Grade {

    Integer id;
    Integer studentId;
    Integer courseId;
    String letterGrade;

    Grade(Integer id, Integer studentId, Integer courseId, String letterGrade) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.letterGrade = letterGrade;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getStudentId() { return studentId; }

    public void setStudentId(Integer studentId) { this.studentId = studentId; }

    public Integer getCourseId() { return courseId; }

    public void setCourseId(Integer courseId) { this.courseId = courseId; }

    public String getLetterGrade() { return letterGrade; }

    public void setLetterGrade(String letterGrade) { this.letterGrade = letterGrade; }

}
