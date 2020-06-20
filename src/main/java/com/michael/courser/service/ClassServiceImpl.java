package com.michael.courser.service;

import com.michael.courser.model.Class;
import com.michael.courser.responses.ClassResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    private final Logger _log = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Override
    public ClassResponse createClass(Class newClass) {
        _log.trace("Enter...", newClass);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public ClassResponse getClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public ClassResponse updateClassById(String id, Class modifiedClass) {
        _log.trace("Enter...", id, modifiedClass);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public ClassResponse deleteClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public ClassResponse registerClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public ClassResponse deregisterClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public ClassResponse getClassesByAttributes() {
        _log.trace("Enter...");
        _log.trace("Exit...");
        return null;
    }
}
