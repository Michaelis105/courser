package com.michael.courser.model;

public class Instructor extends Person {

    private Integer departmentId;

    public Instructor(String id) {
        this(id, "", "");
    }

    public Instructor(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }


}
