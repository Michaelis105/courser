package com.michael.courser.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDaoImpl {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}
