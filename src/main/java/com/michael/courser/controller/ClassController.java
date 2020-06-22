package com.michael.courser.controller;

import com.michael.courser.model.Class;
import com.michael.courser.service.ClassService;
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
 * Endpoints for various class APIs
 */
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for classes")
public class ClassController {

    private final Logger _log = LoggerFactory.getLogger(ClassController.class);

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/v1/class", method = RequestMethod.POST)
    @ApiOperation(value = "Creates new class.")
    public ResponseEntity<Class> createClass(Class newClass) {
        _log.trace("Enter...", newClass);
        Class aNewClass;
        try {
            aNewClass = classService.createClass(newClass);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", aNewClass);
        return (aNewClass == null) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(aNewClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a class by ID.")
    public ResponseEntity<Class> getClassById(@PathVariable("id") String id) {
        _log.trace("Enter...", id);
        Class someClass;
        try {
            someClass = classService.getClassById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", someClass);
        return (someClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someClass);
    }

    @RequestMapping(value = "/v1/class", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a list of classes by filtered attributes.")
    public ResponseEntity<List<Class>> getClassesByAttributes() {
        _log.trace("Enter...");
        List<Class> someClass;
        try {
            someClass = classService.getClassesByAttributes();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", someClass);
        return (someClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Updates a class by ID with modified attributes.")
    public ResponseEntity<Class> updateClassById(@PathVariable("id") String id, Class modifiedClass) {
        _log.trace("Enter...", id, modifiedClass);
        Class aModifiedClass;
        try {
           aModifiedClass = classService.updateClassById(id, modifiedClass);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", aModifiedClass);
        return (aModifiedClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(aModifiedClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes a class by ID.")
    public ResponseEntity<Class> deleteClassById(@PathVariable("id") String id) {
        _log.trace("Enter...", id);
        Class deletedClass;
        try {
            deletedClass = classService.deleteClassById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", deletedClass);
        return (deletedClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(deletedClass);
    }

}
