package com.michael.courser.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A class is a scheduled component instance of a course.
 */
public class Class {

    private String classId;
    private String courseId;
    private String term;

    private String classType;

    private String campus;
    private String instructor;

    private List<String> attributes;

    private List<ClassTime> classTimes;

    private int seatCapacity;
    private int seatOccupied;

    private int seatWaitlistCapacity;
    private int seatWaitlistOccupied;

    public Class(String classId) {
        this(classId, "1234", "SUM2020", "U", "C", "First Name Last Name",
                new LinkedList<String>(Arrays.asList("dummy")),null, 0, 0, 0, 0);
    }

    public Class(String classId, String courseId, String term, String classType, String campus, String instructor,
                 List<String> attributes, List<String> days) {
        this(classId, courseId, term, classType, campus, instructor, attributes, null,
                0, 0, 0, 0);
    }

    public Class(String classId, String courseId, String term, String classType, String campus, String instructor,
                 List<String> attributes, List<ClassTime> classTimes,
                 int seatCapacity, int seatOccupied, int seatWaitlistCapacity, int seatWaitlistOccupied) {
        this.classId = classId;
        this.courseId = courseId;
        this.term = term;
        this.classType = classType;
        this.campus = campus;
        this.instructor = instructor;
        this.attributes = attributes;
        this.classTimes = classTimes;
        this.seatCapacity = seatCapacity;
        this.seatOccupied = seatOccupied;
        this.seatWaitlistCapacity = seatWaitlistCapacity;
        this.seatWaitlistOccupied = seatWaitlistOccupied;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public List<ClassTime> getClassTimes() {
        return classTimes;
    }

    public void setClassTimes(List<ClassTime> classTimes) {
        this.classTimes = classTimes;
    }


    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public int getSeatOccupied() {
        return seatOccupied;
    }

    public void setSeatOccupied(int seatOccupied) {
        this.seatOccupied = seatOccupied;
    }

    public int getSeatWaitlistCapacity() {
        return seatWaitlistCapacity;
    }

    public void setSeatWaitlistCapacity(int seatWaitlistCapacity) {
        this.seatWaitlistCapacity = seatWaitlistCapacity;
    }

    public int getSeatWaitlistOccupied() {
        return seatWaitlistOccupied;
    }

    public void setSeatWaitlistOccupied(int seatWaitlistOccupied) {
        this.seatWaitlistOccupied = seatWaitlistOccupied;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId='" + classId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", term='" + term + '\'' +
                ", classType='" + classType + '\'' +
                ", campus='" + campus + '\'' +
                ", instructor='" + instructor + '\'' +
                ", attributes=" + attributes +
                ", classTimes=" + classTimes +
                ", seatCapacity=" + seatCapacity +
                ", seatOccupied=" + seatOccupied +
                ", seatWaitlistCapacity=" + seatWaitlistCapacity +
                ", seatWaitlistOccupied=" + seatWaitlistOccupied +
                '}';
    }
}