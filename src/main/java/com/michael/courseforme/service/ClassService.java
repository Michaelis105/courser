package com.michael.courseforme.service;

import com.michael.courseforme.model.Class;
import com.michael.courseforme.responses.ClassResponse;

public interface ClassService {

    ClassResponse createClass(Class newClass);
    ClassResponse getClassById(String id);
    ClassResponse updateClassById(String id, Class modifiedClass);
    ClassResponse deleteClassById(String id);

    ClassResponse registerClassById(String id);
    ClassResponse deregisterClassById(String id);
}
