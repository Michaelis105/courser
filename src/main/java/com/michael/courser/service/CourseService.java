package com.michael.courser.service;

import com.michael.courser.model.Course;

public interface CourseService {

    String createCourse(Course newCourse);
    Course getCourseById(String id);
    void updateCourseById(String id, Course modifiedCourse);
    void deleteCourseById(String id);

}
