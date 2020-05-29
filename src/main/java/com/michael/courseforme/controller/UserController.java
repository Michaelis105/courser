package com.michael.courseforme.controller;

import com.michael.courseforme.responses.ClassResponse;
import com.michael.courseforme.responses.UserResponse;
import com.michael.courseforme.service.ClassService;
import com.michael.courseforme.service.UserService;
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
 * Endpoints for various user APIs
 */
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for classes")
public class UserController {

    private final Logger _log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userServicee;

    @RequestMapping(value = "/v1/user/class/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "Registers a class by ID to a student.")
    public UserResponse registerClassById(@PathVariable("id") String id) {
        return userServicee.registerClassById(id);
    }

    @RequestMapping(value = "/v1/user/class/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deregisters a class by ID to a student.")
    public UserResponse deregisterClassById(@PathVariable("id") String id) {
        return userServicee.deregisterClassById(id);
    }
}
