package com.michael.courser.service;

import com.michael.courser.responses.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse login(String username, String password);
    AuthenticationResponse logout();

}
