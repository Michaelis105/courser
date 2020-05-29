package com.michael.courseforme.dao;

import org.springframework.jdbc.core.RowMapper;
import com.michael.courseforme.model.Class;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassMapper implements RowMapper<Class> {
    @Override
    public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
