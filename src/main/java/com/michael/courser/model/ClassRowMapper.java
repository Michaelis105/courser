package com.michael.courser.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ClassRowMapper implements RowMapper<Class> {

    @Override
    public Class mapRow(ResultSet rs, int rowNum) throws SQLException {
        Class aClass = new Class(rs.getInt("id"));
        aClass.setCourseId(rs.getInt("course_id"));
        aClass.setTerm(String.valueOf(rs.getInt("term_id")));
        aClass.setClassType(String.valueOf(rs.getInt("class_type")));
        aClass.setCampus(String.valueOf(rs.getInt("campus")));
        aClass.setInstructor(String.valueOf(rs.getInt("instructor")));

        List<ClassTime> classTimeList = new LinkedList<>();

        Integer classTimeBegin = rs.getInt("class_time_begin");
        LocalTime begin = LocalTime.of(classTimeBegin / 100, classTimeBegin % 100, 0);

        Integer classTimeEnd = rs.getInt("class_time_end");
        LocalTime end = LocalTime.of(classTimeEnd / 100, classTimeEnd % 100, 0);

        String[] days = rs.getString("days").split(",");
        for (String day : days) {
            classTimeList.add(new ClassTime(DayOfWeek.of(Integer.valueOf(day)), begin, end));
        }

        aClass.setClassTimes(classTimeList);

        aClass.setSeatCapacity(rs.getInt("seat_capacity"));
        aClass.setSeatOccupied(rs.getInt("seat_occupied"));
        aClass.setSeatWaitlistCapacity(rs.getInt("seat_waitlist_capacity"));
        aClass.setSeatOccupied(rs.getInt("seat_waitlist_occupied"));

        aClass.setAttributes(new HashMap<>());
        return aClass;
    }

}