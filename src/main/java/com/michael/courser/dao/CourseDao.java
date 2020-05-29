package com.michael.courser.dao;

import com.michael.courser.model.Course;

public interface CourseDao {

    String createCourse(Course newCourse);
    Course getCourseById(String id);
    void updateCourseById(String id, Course modifiedCourse);
    void deleteCourseById(String id);

}
