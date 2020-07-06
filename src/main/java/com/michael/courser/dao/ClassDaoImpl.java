package com.michael.courser.dao;

import com.michael.courser.model.Class;
import com.michael.courser.model.ClassRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassDaoImpl implements ClassDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetLastAutoIncrementValue = "select last_insert_rowid();";
    String sqlInsertClass = "";
    String sqlGetClassById = "SELECT * FROM CLASS WHERE ID=:id";
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
    public List<Class> getClassesByAttributes(Integer id) {
        // TODO: Implement
        return null;
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