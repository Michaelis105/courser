package com.michael.courser.dao;

import com.michael.courser.model.Person;
import com.michael.courser.model.PersonRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PersonDaoImpl implements PersonDao {

    private final Logger _log = LoggerFactory.getLogger(PersonDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    String sqlGetPersonById = "SELECT * FROM PERSON WHERE ID=:id";

    @Override
    public Person getPersonById(int id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));
        return jdbcTemplate.queryForObject(sqlGetPersonById, params, new PersonRowMapper());
    }
}
