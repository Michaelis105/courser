package com.michael.courser.dao;

import com.michael.courser.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassDaoImpl implements ClassDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetLastAutoIncrementValue = "select last_insert_rowid();";
    String sqlInsertCourse = "";
    String sqlGetCourseById = "SELECT * FROM CLASS WHERE ID=:id";
    String sqlUpdateCourse = "";
    String sqlDeleteCourse = "";


    @Override
    public Integer createClass(Class newClass) {
        // NOTE: Forgo implementation for now.
        return null;
    }

    @Override
    public List<Class> getClassById(Integer id) {

        Map<String, String> params = new HashMap<>();
        params.put("id", id.toString());
        return jdbcTemplate.query(sqlGetCourseById, new RowMapper<Class>() {

            @Override
            public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
                Class aClass = new Class(rs.getInt("id"));
                aClass.setCourseId(rs.getInt("course_id"));
                aClass.setTerm(String.valueOf(rs.getInt("term_id")));
                aClass.setClassType(String.valueOf(rs.getInt("class_type")));
                aClass.setCampus(String.valueOf(rs.getInt("campus")));
                aClass.setInstructor(rs.getString("instructor"));

                //aClass.setCourseId(rs.getInt("days"));
                //aClass.setCourseId(rs.getInt("class_time_begin"));
                //aClass.setCourseId(rs.getInt("class_time_end"));

                aClass.setSeatCapacity(rs.getInt("seat_capacity"));
                aClass.setSeatOccupied(rs.getInt("seat_occupied"));
                aClass.setSeatWaitlistCapacity(rs.getInt("seat_waitlist_capacity"));
                aClass.setSeatOccupied(rs.getInt("seat_waitlist_occupied"));
                return aClass;
            }
        });
        //List<ClassTime> classTimes,
    }

    @Override
    public void updateClassById(Integer id, Class modifiedClass) {
        // NOTE: Forgo implementation for now.
    }

    @Override
    public void deleteClassById(Integer id) {
        // NOTE: Forgo implementation for now.
    }
}