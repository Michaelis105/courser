package com.michael.courser.service;

import com.michael.courser.dao.CourseDao;
import com.michael.courser.model.Course;
import com.michael.courser.responses.CourseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    private final Logger _log = LoggerFactory.getLogger(ClassServiceImpl.class);

    @Autowired
    CourseDao courseDao;

    @Override
    public CourseResponse createCourse(Course newCourse) {
        _log.trace("Enter...", newCourse);
        String newCourseId = courseDao.createCourse(newCourse);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public CourseResponse getCourseById(String id) {
        _log.trace("Enter...", id);
        Course course = courseDao.getCourseById(id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public CourseResponse updateCourseById(String id, Course modifiedCourse) {
        _log.trace("Enter...", id, modifiedCourse);
        courseDao.updateCourseById(id, modifiedCourse);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public CourseResponse deleteCourseById(String id) {
        _log.trace("Enter...", id);
        courseDao.deleteCourseById(id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public CourseResponse getCoursesByAttributes() {
        _log.trace("Enter...");
        _log.trace("Exit...");
        return null;
    }
}
