package com.michael.courser.dao;

import com.michael.courser.model.Course;
import com.michael.courser.model.CourseRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class CourseDaoImpl implements CourseDao {

    private final Logger _log = LoggerFactory.getLogger(CourseDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetLastAutoIncrementValue = "select last_insert_rowid();";
    String sqlInsertCourse = "";
    String sqlGetCourseRoot = "SELECT * FROM COURSE";
    String sqlGetCourseById = "SELECT * FROM COURSE WHERE ID=:id";
    String sqlGetCourseByCourseNumber = "SELECT * FROM COURSE WHERE number=:number";
    String sqlUpdateCourse = "";
    String sqlDeleteCourse = "";

    @Override
    public Integer createCourse(Course newCourse) {
        // NOTE: Forgo implementation for now.
        return null;
    }

    @Override
    public Course getCourseById(Integer id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id.toString());
        return jdbcTemplate.queryForObject(sqlGetCourseById, params, new CourseRowMapper());
    }

    @Override
    public List<Course> getCoursesByAttributes(String subject, String number, String title, String credit) {
        Map<String, String> params = new HashMap<>();

        String sqlByAttributes = sqlGetCourseRoot + " WHERE ";
        List<String> cond = new LinkedList<>();
        if (subject != null && !subject.isBlank()) {
            params.put("subject", subject);
            cond.add("SUBJECT=:subject");
        }

        if (number != null && !number.isBlank()) {
            if (number.contains("*")) {
                number = number.replace("*", "");
                params.put("number", number + "%");
                cond.add("NUMBER LIKE :number");
            } else {
                params.put("number", number);
                cond.add("NUMBER=:number");
            }

        }

        if (title != null && !title.isBlank()) {
            params.put("title", title + "%");
            cond.add("TITLE LIKE :title");
        }

        if (credit != null && !credit.isBlank()) {
            params.put("credit", credit);
            cond.add("CREDIT=:credit");
        }

        String finalCond = String.join(" AND ", cond);
        _log.debug(sqlByAttributes + finalCond);

        return jdbcTemplate.query(sqlByAttributes + finalCond, params, new CourseRowMapper());
    }



    @Override
    public void updateCourseById(Integer id, Course modifiedCourse) {
        // NOTE: Forgo implementation for now.
    }

    @Override
    public void deleteCourseById(Integer id) {
        // NOTE: Forgo implementation for now.
    }
}
