package com.michael.courser.dao;

import com.michael.courser.model.Course;

import java.util.List;

public interface CourseDao {

    Integer createCourse(Course newCourse);
    Course getCourseById(Integer id);
    List<Course> getCoursesByAttributes(String subject, String number, String title, String credit);
    void updateCourseById(Integer id, Course modifiedCourse);
    void deleteCourseById(Integer id);

}
