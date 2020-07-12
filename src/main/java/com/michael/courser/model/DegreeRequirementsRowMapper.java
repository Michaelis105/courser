package com.michael.courser.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DegreeRequirementsRowMapper implements RowMapper<DegreeRequirements> {

    @Override
    public DegreeRequirements mapRow(ResultSet rs, int i) throws SQLException {

        int id = rs.getInt("id");
        String subject = rs.getString("subject");
        String degreeLevel = rs.getString("degree_level");
        String[] prereqsStr = rs.getString("course_requirements").split(",");
        List<Integer> prereqs = new LinkedList<>();
        for (String s : prereqsStr) {
            prereqs.add(Integer.valueOf(s));
        }

        return new DegreeRequirements(id, subject, degreeLevel, prereqs);
    }
}
