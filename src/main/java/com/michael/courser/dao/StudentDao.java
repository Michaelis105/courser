package com.michael.courser.dao;

import com.michael.courser.model.Grade;

import java.util.List;

public interface StudentDao {

    List<Grade> getGradesByStudentId(Integer studentId);
}
