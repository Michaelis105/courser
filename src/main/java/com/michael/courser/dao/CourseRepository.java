package com.michael.courser.dao;

import com.michael.courser.model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, String> {

}
