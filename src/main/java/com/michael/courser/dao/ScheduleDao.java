package com.michael.courser.dao;

import com.michael.courser.model.Course;
import com.michael.courser.model.DegreeRequirements;

import java.util.List;

public interface ScheduleDao {

    DegreeRequirements getCoursesByDegreeRequirements(int degreeId);
}
