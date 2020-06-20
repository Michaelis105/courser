package com.michael.courser.controller;

import com.michael.courser.model.Class;
import com.michael.courser.responses.ClassResponse;
import com.michael.courser.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ClassResponse createClass(Class newClass) {
        return classService.createClass(newClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a class by ID.")
    public ClassResponse getClassById(@PathVariable("id") String id) {
        return classService.getClassById(id);
    }

    @RequestMapping(value = "/v1/class", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a list of classes by filtered attributes.")
    public ClassResponse getClassesByAttributes() {
        return classService.getClassesByAttributes();
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.PATCH)
    @ApiOperation(value = "Updates a class by ID with modified attributes.")
    public ClassResponse updateClassById(@PathVariable("id") String id, Class modifiedClass) {
        return classService.updateClassById(id, modifiedClass);
    }

    @RequestMapping(value = "/v1/class/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes a class by ID.")
    public ClassResponse deleteClassById(@PathVariable("id") String id) {
        return classService.deleteClassById(id);
    }

}
