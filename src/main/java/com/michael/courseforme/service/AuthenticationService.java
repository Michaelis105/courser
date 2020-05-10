package com.michael.courseforme.service;

import com.michael.courseforme.responses.AuthenticationResponse;

public interface AuthenticationService {

    AuthenticationResponse login(String username, String password);
    AuthenticationResponse logout();

}
