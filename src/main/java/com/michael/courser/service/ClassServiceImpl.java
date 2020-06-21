package com.michael.courser.service;

import com.michael.courser.model.Class;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final Logger _log = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Override
    public Class createClass(Class newClass) {
        _log.trace("Enter...", newClass);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public Class getClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public Class updateClassById(String id, Class modifiedClass) {
        _log.trace("Enter...", id, modifiedClass);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public Class deleteClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public Class registerClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public Class deregisterClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public List<Class> getClassesByAttributes() {
        _log.trace("Enter...");
        _log.trace("Exit...");
        return null;
    }
}
