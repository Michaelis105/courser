package com.michael.courser.service;

import com.michael.courser.model.Course;
import com.michael.courser.responses.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse createCourse(Course newCourse);
    CourseResponse getCourseById(String id);
    CourseResponse updateCourseById(String id, Course modifiedCourse);
    CourseResponse deleteCourseById(String id);

    CourseResponse getCoursesByAttributes();

}
