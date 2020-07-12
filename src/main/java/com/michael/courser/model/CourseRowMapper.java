package com.michael.courser.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CourseRowMapper implements RowMapper<Course> {

    @Override
    public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

        Course aCourse = new Course(rs.getInt("id"));
        aCourse.setSubject(rs.getString("subject"));
        aCourse.setNumber(rs.getInt("number"));
        aCourse.setCourseTitle(rs.getString("title"));
        aCourse.setCreditCount(rs.getInt("credit"));
        aCourse.setDescription(rs.getString("description"));
        aCourse.setUrl(rs.getString("url"));

        String[] prereqsSplit = rs.getString("prerequisite").split(",");
        List<Integer> prereqs = new LinkedList<>();
        for (String sp : prereqsSplit) {
            prereqs.add(Integer.valueOf(sp));
        }
        aCourse.setPrerequisiteIds(prereqs);

        return aCourse;
    }
}
