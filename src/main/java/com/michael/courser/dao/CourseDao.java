package com.michael.courser.dao;

import com.michael.courser.model.Course;

public interface CourseDao {

    Integer createCourse(Course newCourse);
    Course getCourseById(Integer id);
    void updateCourseById(Integer id, Course modifiedCourse);
    void deleteCourseById(Integer id);

}
