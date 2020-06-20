package com.michael.courser.controller;

import com.michael.courser.model.Course;
import com.michael.courser.responses.ClassResponse;
import com.michael.courser.responses.CourseResponse;
import com.michael.courser.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Endpoints for various course APIs
 */
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for courses")
public class CourseController {

    private final Logger _log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/v1/course", method = RequestMethod.POST)
    @ApiOperation(value = "Creates new course.")
    public CourseResponse createCourse(Course newCourse) {
        return courseService.createCourse(newCourse);
    }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a course by ID.")
    public CourseResponse getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id);
    }

    @RequestMapping(value = "/v1/course", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a list of courses by filtered attributes.")
    public CourseResponse getCoursesByAttributes() { return courseService.getCoursesByAttributes(); }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Updates a course by ID with modified attributes.")
    public CourseResponse getCourseById(@PathVariable("id") String id, Course modifiedCourse) { return courseService.updateCourseById(id, modifiedCourse); }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes a course by ID.")
    public CourseResponse deleteCourseById(@PathVariable("id") String id) { return courseService.deleteCourseById(id); }

}
