package com.michael.courser.service;

import com.michael.courser.dao.CourseDao;
import com.michael.courser.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final Logger _log = LoggerFactory.getLogger(ClassServiceImpl.class);

    //@Autowired
    //CourseDao courseDao;

    @Override
    public Course createCourse(Course newCourse) {
        _log.trace("Enter...", newCourse);
        //String newCourseId = courseDao.createCourse(newCourse);
        // TODO: IMPLEMENT
        Course dummyCourse = new Course("CREATE" + newCourse.getCourseId());
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public Course getCourseById(String id) {
        _log.trace("Enter...", id);
        //Course course = courseDao.getCourseById(id);
        // TODO: IMPLEMENT
        Course dummyCourse = new Course("GET" + id);
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public Course updateCourseById(String id, Course modifiedCourse) {
        _log.trace("Enter...", id, modifiedCourse);
        //courseDao.updateCourseById(id, modifiedCourse);
        // TODO: IMPLEMENT
        Course dummyCourse = new Course("UPDATE" + id);
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public Course deleteCourseById(String id) {
        _log.trace("Enter...", id);
        //courseDao.deleteCourseById(id);
        // TODO: IMPLEMENT
        Course dummyCourse = new Course("DELETE" + id);
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public List<Course> getCoursesByAttributes() {
        _log.trace("Enter...");
        // TODO: IMPLEMENT
        List<Course> coursesList = new LinkedList<>();
        coursesList.add(new Course("1"));
        coursesList.add(new Course("2"));
        coursesList.add(new Course("3"));
        _log.trace("Exit...");
        return coursesList;
    }
}
