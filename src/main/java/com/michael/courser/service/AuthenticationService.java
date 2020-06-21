package com.michael.courser.service;

import com.michael.courser.model.SessionInfo;

public interface AuthenticationService {

    SessionInfo login(String username, String password);
    SessionInfo logout();

}
