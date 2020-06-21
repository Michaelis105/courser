package com.michael.courser.controller;

import com.michael.courser.model.Class;
import com.michael.courser.model.Schedule;
import com.michael.courser.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints for various student APIs
 */
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for classes")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/v1/student/schedule/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a student's schedule")
    public ResponseEntity<Schedule> getStudentSchedule(@PathVariable("sid") String scheduleId) {
        Schedule someSchedule = studentService.getStudentSchedule(scheduleId);
        return (someSchedule == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someSchedule);
    }

    @RequestMapping(value = "/v1/student/class/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "Registers a class by ID to a student's schedule .")
    public ResponseEntity<Class> registerClassById(@PathVariable("cid") String courseId, @PathVariable("sid") String scheduleId) {
        Class someClass = studentService.registerClassById(courseId, scheduleId);
        return (someClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someClass);
    }

    @RequestMapping(value = "/v1/student/class/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deregisters a class by ID from a student's schedule.")
    public ResponseEntity<Class> deregisterClassById(@PathVariable("cid") String courseId, @PathVariable("sid") String scheduleId) {
        Class someClass = studentService.deregisterClassById(courseId, scheduleId);
        return (someClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someClass);
    }
}
