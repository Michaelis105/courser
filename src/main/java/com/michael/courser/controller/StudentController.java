package com.michael.courser.controller;

import com.michael.courser.responses.StudentResponse;
import com.michael.courser.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final Logger _log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/v1/student/schedule/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a student's schedule")
    public StudentResponse getStudentSchedule(@PathVariable("sid") String scheduleId) { return studentService.getStudentSchedule(scheduleId); }

    @RequestMapping(value = "/v1/student/class/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "Registers a class by ID to a student's schedule .")
    public StudentResponse registerClassById(@PathVariable("cid") String courseId, @PathVariable("sid") String scheduleId) { return studentService.registerClassById(courseId, scheduleId); }

    @RequestMapping(value = "/v1/student/class/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deregisters a class by ID from a student's schedule.")
    public StudentResponse deregisterClassById(@PathVariable("cid") String courseId, @PathVariable("sid") String scheduleId) { return studentService.deregisterClassById(courseId, scheduleId); }
}
