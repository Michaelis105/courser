package com.michael.courser.dao;

import com.michael.courser.model.Course;
import com.michael.courser.model.CourseRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScheduleDaoImpl implements ScheduleDao {

    private final Logger _log = LoggerFactory.getLogger(ScheduleDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetCoursesByDegreeRequirements = "SELECT * FROM COURSE WHERE PREREQUISITE IN (:course_id_list)";

    @Override
    public List<Course> getCoursesByDegreeRequirements(int degreeId) {
        Map<String, String> params = new HashMap<>();
        params.put("course_id_list", String.valueOf(degreeId));
        return jdbcTemplate.query(sqlGetCoursesByDegreeRequirements, params, new CourseRowMapper());
    }
}
