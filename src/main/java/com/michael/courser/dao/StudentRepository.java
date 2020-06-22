package com.michael.courser.dao;

import com.michael.courser.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, String> {

}
