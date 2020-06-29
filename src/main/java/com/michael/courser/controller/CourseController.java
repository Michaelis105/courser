package com.michael.courser.controller;

import com.michael.courser.model.Course;
import com.michael.courser.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints for various course APIs
 */
@CrossOrigin
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for courses")
public class CourseController {

    private final Logger _log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/v1/course", method = RequestMethod.POST)
    @ApiOperation(value = "Creates new course.")
    public ResponseEntity<Course> createCourse(Course newCourse) {
        _log.trace("Enter...", newCourse);
        Course aCourse;
        try {
            aCourse = courseService.createCourse(newCourse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", aCourse);
        return (aCourse == null) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(aCourse);
    }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a course by ID.")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id) {
        _log.trace("Enter...", id);
        Course someCourse;
        try {
            someCourse = courseService.getCourseById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", id);
        return (someCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someCourse);
    }

    @RequestMapping(value = "/v1/course", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a list of courses by filtered attributes.")
    public ResponseEntity<List<Course>> getCoursesByAttributes() {
        _log.trace("Enter...");
        List<Course> someCourse;
        try {
            someCourse = courseService.getCoursesByAttributes();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...");
        return (someCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someCourse);
    }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Updates a course by ID with modified attributes.")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") String id, Course modifiedCourse) {
        _log.trace("Enter...", id, modifiedCourse);
        Course aModifiedCourse;
        try {
            aModifiedCourse = courseService.updateCourseById(id, modifiedCourse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", aModifiedCourse);
        return (aModifiedCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(aModifiedCourse);
    }

    @RequestMapping(value = "/v1/course/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes a course by ID.")
    public ResponseEntity<Course> deleteCourseById(@PathVariable("id") String id) {
        _log.trace("Enter...", id);
        Course deletedCourse;
        try {
            deletedCourse = courseService.deleteCourseById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", deletedCourse);
        return (deletedCourse == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(deletedCourse);
    }

}
