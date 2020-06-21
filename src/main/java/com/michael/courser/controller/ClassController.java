package com.michael.courser.controller;

import com.michael.courser.model.Class;
import com.michael.courser.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ClassService classService;

    @RequestMapping(value = "/v1/class", method = RequestMethod.POST)
    @ApiOperation(value = "Creates new class.")
    public ResponseEntity<Class> createClass(Class newClass) {
        Class aNewClass = classService.createClass(newClass);
        return (aNewClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(aNewClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a class by ID.")
    public ResponseEntity<Class> getClassById(@PathVariable("id") String id) {
        Class someClass = classService.getClassById(id);
        return (someClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someClass);
    }

    @RequestMapping(value = "/v1/class", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a list of classes by filtered attributes.")
    public ResponseEntity<List<Class>> getClassesByAttributes() {
        List<Class> someClass = classService.getClassesByAttributes();
        return (someClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(someClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Updates a class by ID with modified attributes.")
    public ResponseEntity<Class> updateClassById(@PathVariable("id") String id, Class modifiedClass) {
        Class aModifiedClass = classService.updateClassById(id, modifiedClass);
        return (aModifiedClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(aModifiedClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes a class by ID.")
    public ResponseEntity<Class> deleteClassById(@PathVariable("id") String id) {
        Class deletedNewClass = classService.deleteClassById(id);
        return (deletedNewClass == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(deletedNewClass);
    }

}
