package com.michael.courser.dao;

import com.michael.courser.model.DegreeRequirements;
import com.michael.courser.model.DegreeRequirementsRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ScheduleDaoImpl implements ScheduleDao {

    private final Logger _log = LoggerFactory.getLogger(ScheduleDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetCoursesByDegreeRequirementsId = "SELECT * FROM DEGREEREQUIREMENTS WHERE ID=:degree_id";
    // PREREQUISITE IN (:course_id_list)";

    @Override
    public DegreeRequirements getCoursesByDegreeRequirements(int degreeId) {
        Map<String, String> params = new HashMap<>();
        params.put("degree_id", String.valueOf(degreeId));
        return jdbcTemplate.queryForObject(sqlGetCoursesByDegreeRequirementsId, params, new DegreeRequirementsRowMapper());
    }
}
