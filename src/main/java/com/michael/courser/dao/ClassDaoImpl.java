package com.michael.courser.dao;

import com.michael.courser.model.Class;
import com.michael.courser.model.ClassRowMapper;
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
public class ClassDaoImpl implements ClassDao {

    private final Logger _log = LoggerFactory.getLogger(ClassDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetLastAutoIncrementValue = "select last_insert_rowid();";
    String sqlInsertClass = "";
    String sqlGetClassRoot = "SELECT * FROM CLASS";
    String sqlGetClassById = "SELECT * FROM CLASS WHERE ID=:id";
    String sqlGetClassesByCourseNumber = "SELECT CLASS.* FROM COURSE INNER JOIN CLASS ON COURSE.ID = CLASS.COURSE_ID WHERE NUMBER = :number";
    String sqlUpdateClass = "";
    String sqlDeleteClass = "";

    @Override
    public Integer createClass(Class newClass) {
        // NOTE: Forgo implementation for now.
        return null;
    }

    @Override
    public Class getClassById(Integer id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id.toString());
        return jdbcTemplate.queryForObject(sqlGetClassById, params, new ClassRowMapper());
    }

    @Override
    public List<Class> getClassesByAttributes(String courseId, String instructor, String days, String beginTime, String endTime, Boolean isAvailable) {
        Map<String, String> params = new HashMap<>();

        String sqlByAttributes = sqlGetClassRoot + " WHERE ";
        List<String> cond = new LinkedList<>();

        if (courseId != null) {
            if (courseId.contains("*")) {
                courseId = courseId.replace("*", "");
                params.put("course_id", courseId + "%");
                cond.add("COURSE_ID LIKE :course_id");
            } else {
                params.put("course_id", courseId);
                cond.add("COURSE_ID=:course_id");
            }
        }

        if (instructor != null) {
            params.put("instructor", instructor + "%");
            cond.add("INSTRUCTOR LIKE :instructor");
        }

        if (days != null) {
            String[] daysParsed = days.split(",");
            for (String d : daysParsed) {
                int dbNum = 0; // Gets int that is compatible with DB
                switch (d) {
                    case "M":
                        dbNum = 1;
                        break;
                    case "T":
                        dbNum = 2;
                        break;
                    case "W":
                        dbNum = 3;
                        break;
                    case "R":
                        dbNum = 4;
                        break;
                    case "F":
                        dbNum = 5;
                        break;
                    case "A":
                        dbNum = 6;
                        break;
                    case "U":
                        dbNum = 7;
                        break;
                    default:
                        // eh, do nothing for now.
                }
                params.put("day" + dbNum, "%" + dbNum + "%");
                cond.add("DAYS LIKE " + ":day" + dbNum);
            }
        }

        if (beginTime != null) {
            params.put("class_time_begin", beginTime);
            cond.add("CLASS_TIME_BEGIN >= :class_time_begin");
        }

        if (endTime != null) {
            params.put("class_time_end", endTime);
            cond.add("CLASS_TIME_END <= :class_time_end");
        }

        if (isAvailable != null && isAvailable) {
            cond.add("SEAT_OCCUPIED < SEAT_CAPACITY");
        }

        String finalCond = String.join(" AND ", cond);
        _log.debug(sqlByAttributes + finalCond);

        return jdbcTemplate.query(sqlByAttributes + finalCond, params, new ClassRowMapper());
    }

    @Override
    public List<Class> getClassesByCourseNumber(String courseNumber) {
        Map<String, String> params = new HashMap<>();
        params.put("number", courseNumber);
        return jdbcTemplate.query(sqlGetClassesByCourseNumber, params, new ClassRowMapper());
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