package com.michael.courser.model;

public class Student extends Person {

    public Student(String id) {
        super(id);
    }

    public Student(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
