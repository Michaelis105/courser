package com.michael.courser.dao;

import org.springframework.jdbc.core.RowMapper;
import com.michael.courser.model.Class;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClassMapper implements RowMapper<Class> {
    @Override
    public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
