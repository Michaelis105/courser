package com.michael.courseforme.service;

import com.michael.courseforme.responses.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final Logger _log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserResponse registerClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }

    @Override
    public UserResponse deregisterClassById(String id) {
        _log.trace("Enter...", id);
        _log.trace("Exit...");
        return null;
    }
}
