package com.michael.courser.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeRowMapper implements RowMapper<Grade> {

    @Override
    public Grade mapRow(ResultSet rs, int i) throws SQLException {

        int id = rs.getInt("id");
        int studentId = rs.getInt("student_id");
        int courseId = rs.getInt("course_id");
        String letterGrade = rs.getString("letter_grade");

        return new Grade(id, studentId, courseId, letterGrade);
    }
}
