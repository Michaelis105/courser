package com.michael.courser.service;

import com.michael.courser.model.SessionInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final Logger _log = LoggerFactory.getLogger(AuthenticationServiceImpl.class);

    @Override
    public SessionInfo login(String username, String password) {
        _log.trace("Enter...", username, password);
        // TODO: IMPLEMENT
        _log.trace("Exit...");
        return null;
    }

    @Override
    public SessionInfo logout() {
        _log.trace("Enter...");
        // TODO: IMPLEMENT
        _log.trace("Exit...");
        return null;
    }
}
