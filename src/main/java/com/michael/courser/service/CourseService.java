package com.michael.courser.service;

import com.michael.courser.model.Course;

import java.util.List;

public interface CourseService {

    Course createCourse(Course newCourse);
    Course getCourseById(String id);
    Course updateCourseById(String id, Course modifiedCourse);
    Course deleteCourseById(String id);

    List<Course> getCoursesByAttributes();

}
