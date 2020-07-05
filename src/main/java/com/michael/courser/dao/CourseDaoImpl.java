package com.michael.courser.dao;

import com.michael.courser.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    String sqlGetLastAutoIncrementValue = "select last_insert_rowid();";
    String sqlInsertCourse = "";
    String sqlGetCourseById = "";
    String sqlUpdateCourse = "";
    String sqlDeleteCourse = "";

    @Override
    public Integer createCourse(Course newCourse) {
        // NOTE: Forgo implementation for now.
        return null;
    }

    @Override
    public Course getCourseById(Integer id) {
        return null;
    }

    @Override
    public void updateCourseById(Integer id, Course modifiedCourse) {
        // NOTE: Forgo implementation for now.
    }

    @Override
    public void deleteCourseById(Integer id) {
        // NOTE: Forgo implementation for now.
    }
}
