package com.michael.courser.service;

import com.michael.courser.responses.UserResponse;

public interface UserService {

    UserResponse registerClassById(String id);
    UserResponse deregisterClassById(String id);

}
