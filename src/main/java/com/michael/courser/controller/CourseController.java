package com.michael.courser.controller;

import com.michael.courser.model.Course;
import com.michael.courser.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints for various course APIs
 */
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/v1/course", method = RequestMethod.POST)
    @ApiOperation(value = "Creates new course.")
    public ResponseEntity<Course> createCourse(Course newCourse) {
        Course aCourse = courseService.createCourse(newCourse);
        return (aCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(aCourse);
    }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a course by ID.")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id) {
        Course someCourse = courseService.getCourseById(id);
        return (someCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someCourse);
    }

    @RequestMapping(value = "/v1/course", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a list of courses by filtered attributes.")
    public ResponseEntity<List<Course>> getCoursesByAttributes() {
        List<Course> someCourse = courseService.getCoursesByAttributes();
        return (someCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someCourse);
    }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Updates a course by ID with modified attributes.")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id, Course modifiedCourse) {
        Course aModifiedCourse = courseService.updateCourseById(id, modifiedCourse);
        return (aModifiedCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(aModifiedCourse);
    }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes a course by ID.")
    public ResponseEntity<Course> deleteCourseById(@PathVariable("id") String id) {
        Course deletedCourse = courseService.deleteCourseById(id);
        return (deletedCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(deletedCourse);
    }

}
