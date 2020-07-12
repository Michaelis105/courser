package com.michael.courser.dao;

import com.michael.courser.model.Course;

import java.util.List;

public interface ScheduleDao {

    List<Course> getCoursesByDegreeRequirements(int degreeId);
}
