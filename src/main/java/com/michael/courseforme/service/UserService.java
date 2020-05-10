package com.michael.courseforme.service;

import com.michael.courseforme.responses.UserResponse;

public interface UserService {

    UserResponse registerClassById(String id);
    UserResponse deregisterClassById(String id);

}
