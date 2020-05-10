package com.michael.courseforme.service;

import com.michael.courseforme.model.Course;
import com.michael.courseforme.responses.CourseResponse;

public interface CourseService {

    CourseResponse createCourse(Course newCourse);
    CourseResponse getCourseById(String id);
    CourseResponse updateCourseById(String id, Course modifiedCourse);
    CourseResponse deleteCourseById(String id);

}
