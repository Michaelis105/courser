package com.michael.courser.service;

import com.michael.courser.dao.StudentDao;
import com.michael.courser.responses.StudentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final Logger _log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentDao studentDao;

    @Override
    public StudentResponse getStudentSchedule(String scheduleId) {
        _log.trace("Enter...", scheduleId);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public StudentResponse registerClassById(String courseId, String scheduleId) {
        _log.trace("Enter...", courseId, scheduleId);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public StudentResponse deregisterClassById(String courseId, String scheduleId) {
        _log.trace("Enter...", courseId, scheduleId);
        _log.trace("Exit...");
        return null;
    }
}
