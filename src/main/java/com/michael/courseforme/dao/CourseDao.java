package com.michael.courseforme.dao;

import com.michael.courseforme.model.Course;

public interface CourseDao {

    String createCourse(Course newCourse);
    Course getCourseById(String id);
    void updateCourseById(String id, Course modifiedCourse);
    void deleteCourseById(String id);

}
