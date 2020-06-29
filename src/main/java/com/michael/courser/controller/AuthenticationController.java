package com.michael.courser.controller;

import com.michael.courser.model.SessionInfo;
import com.michael.courser.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Endpoints for various authentication APIs
 */
@CrossOrigin
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for handling authentication")
public class AuthenticationController {

    private final Logger _log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/v1/auth/login", method = RequestMethod.POST)
    @ApiOperation(value = "Authenticates and creates a session for user.")
    public ResponseEntity<SessionInfo> login(@PathVariable("username") String username, @PathVariable("password") String password) {
        _log.trace("Enter...");
        SessionInfo sessionInfo = authenticationService.login(username, password);
        _log.trace("Exit...");
        return (sessionInfo == null) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(sessionInfo);
    }

    @RequestMapping(value = "/v1/auth/logout", method = RequestMethod.POST)
    @ApiOperation(value = "Invalidates user session.")
    public ResponseEntity<SessionInfo> logout() {
        _log.trace("Enter...");
        SessionInfo sessionInfo = authenticationService.logout();
        _log.trace("Exit...");
        return (sessionInfo == null) ? ResponseEntity.badRequest().build() : ResponseEntity.ok(sessionInfo);
    }

    @RequestMapping(value = "/v1/auth/hello", method = RequestMethod.POST)
    @ApiOperation(value = "Hello!")
    public ResponseEntity<String> hello() {
        _log.trace("Enter...");
        _log.trace("Exit...");
        return ResponseEntity.ok("Hi");
    }

}
