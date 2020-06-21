package com.michael.courser.controller;

import com.michael.courser.model.SessionInfo;
import com.michael.courser.responses.AuthenticationResponse;
import com.michael.courser.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/v1/auth/login", method = RequestMethod.POST)
    @ApiOperation(value = "Authenticates and creates a session for user.")
    public ResponseEntity<SessionInfo> login(String username, String password) {
        SessionInfo sessionInfo = authenticationService.login(username, password);
        return (sessionInfo == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(sessionInfo);
    }

    @RequestMapping(value = "/v1/auth/logout", method = RequestMethod.POST)
    @ApiOperation(value = "Invalidates user session.")
    public ResponseEntity<SessionInfo> logout() {
        SessionInfo sessionInfo = authenticationService.logout();
        return (sessionInfo == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(sessionInfo);
    }

}
