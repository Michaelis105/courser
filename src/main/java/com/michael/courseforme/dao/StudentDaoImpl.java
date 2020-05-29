package com.michael.courseforme.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
