package com.michael.courser.dao;

import com.michael.courser.model.Grade;
import com.michael.courser.model.GradeRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentDaoImpl implements StudentDao {

    private final Logger _log = LoggerFactory.getLogger(StudentDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetGradesByStudentId = "SELECT * FROM GRADE WHERE STUDENT_ID = :student_id";

    @Override
    public List<Grade> getGradesByStudentId(Integer studentId) {
        Map<String, String> params = new HashMap<>();
        params.put("student_id", String.valueOf(studentId));
        return jdbcTemplate.query(sqlGetGradesByStudentId, params, new GradeRowMapper());
    }
}
