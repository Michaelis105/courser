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
        Course dummyCourse = new Course(newCourse.getCourseId());
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public Course getCourseById(Integer id) {
        _log.trace("Enter...", id);
        //Course course = courseDao.getCourseById(id);
        // TODO: IMPLEMENT
        Course dummyCourse = new Course(id);
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public Course updateCourseById(Integer id, Course modifiedCourse) {
        _log.trace("Enter...", id, modifiedCourse);
        //courseDao.updateCourseById(id, modifiedCourse);
        // TODO: IMPLEMENT
        Course dummyCourse = new Course(id);
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public Course deleteCourseById(Integer id) {
        _log.trace("Enter...", id);
        //courseDao.deleteCourseById(id);
        // TODO: IMPLEMENT
        Course dummyCourse = new Course(id);
        _log.trace("Exit...");
        return dummyCourse;
    }

    @Override
    public List<Course> getCoursesByAttributes() {
        _log.trace("Enter...");

        // TODO: IMPLEMENT
        Course aCourse = new Course(1234, "CS", 6460, "Educational Technology", 3, null,
                "Heavily project-based class in which students will: deeply investigate the tools, methods, and " +
                        "theories behind educational technology; demonstrate mastery of a subset of the field;" +
                        " propose either implementing a tool for or conducting research in educational technology;" +
                        " and deliver a final project along with a presentation and publication-ready paper."
        , "https://omscs.gatech.edu/cs-6460-educational-technology");

        Course bCourse = new Course(5543, "CS", 7646, "Machine Learning for Trading", 3, null,
                "Introduces students to the real world challenges of implementing machine learning based " +
                        "trading strategies including the algorithmic steps from information gathering to market orders. " +
                        "The focus is on how to apply probabilistic machine learning approaches to trading decisions. " +
                        "We consider statistical approaches like linear regression, Q-Learning, KNN, and regression " +
                        "trees and how to apply them to actual stock trading situations."
                , "https://omscs.gatech.edu/cs-7646-machine-learning-trading");

        List<Course> coursesList = new LinkedList<>();
        coursesList.add(aCourse);
        coursesList.add(bCourse);
        _log.trace("Exit...");
        return coursesList;
    }
}
