package com.michael.courser.service;

import com.michael.courser.responses.AuthenticationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final Logger _log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public AuthenticationResponse login(String username, String password) {
        _log.trace("Enter...", username, password);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public AuthenticationResponse logout() {
        _log.trace("Enter...");
        _log.trace("Exit...");
        return null;
    }
}
