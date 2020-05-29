package com.michael.courser.service;

import com.michael.courser.dao.CourseDao;
import com.michael.courser.model.Course;
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
    public String createCourse(Course newCourse) {
        _log.trace("Enter...", newCourse);
        String newCourseId = courseDao.createCourse(newCourse);
        _log.trace("Exit...");
        return newCourseId;
    }

    @Override
    public Course getCourseById(String id) {
        _log.trace("Enter...", id);
        Course course = courseDao.getCourseById(id);
        _log.trace("Exit...");
        return course;
    }

    @Override
    public void updateCourseById(String id, Course modifiedCourse) {
        _log.trace("Enter...", id, modifiedCourse);
        courseDao.updateCourseById(id, modifiedCourse);
        _log.trace("Exit...");
    }

    @Override
    public void deleteCourseById(String id) {
        _log.trace("Enter...", id);
        courseDao.deleteCourseById(id);
        _log.trace("Exit...");
    }
}
