package com.michael.courseforme.service;

import com.michael.courseforme.model.Course;
import com.michael.courseforme.responses.CourseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final Logger _log = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Override
    public CourseResponse createCourse(Course newCourse) {
        _log.trace("Enter...", newCourse);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public CourseResponse getCourseById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public CourseResponse updateCourseById(String id, Course modifiedCourse) {
        _log.trace("Enter...", id, modifiedCourse);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public CourseResponse deleteCourseById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }
}
