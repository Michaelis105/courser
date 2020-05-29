package com.michael.courseforme.dao;

import com.michael.courseforme.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CourseDaoImpl implements CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String sqlGetLastAutoIncrementValue = "select last_insert_rowid();";
    String sqlInsertCourse = "";
    String sqlGetCourseById = "";
    String sqlUpdateCourse = "";
    String sqlDeleteCourse = "";

    @Override
    public String createCourse(Course newCourse) {
        return null;
    }

    @Override
    public Course getCourseById(String id) {
        return null;
    }

    @Override
    public void updateCourseById(String id, Course modifiedCourse) {

    }

    @Override
    public void deleteCourseById(String id) {

    }
}
