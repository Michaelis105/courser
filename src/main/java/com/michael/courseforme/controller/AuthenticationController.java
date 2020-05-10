package com.michael.courseforme.controller;

import com.michael.courseforme.responses.AuthenticationResponse;
import com.michael.courseforme.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoints for various authentication APIs
 */
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for handling authentication")
public class AuthenticationController {

    private final Logger _log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/v1/auth/login", method = RequestMethod.POST)
    @ApiOperation(value = "Authenticates and creates a session for user.")
    public AuthenticationResponse login(String username, String password) {
        return authenticationService.login(username, password);
    }

    @RequestMapping(value = "/v1/auth/logout", method = RequestMethod.POST)
    @ApiOperation(value = "Invalidates user session.")
    public AuthenticationResponse logout() {
        return authenticationService.logout();
    }

}
