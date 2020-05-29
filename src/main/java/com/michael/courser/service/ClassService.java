package com.michael.courser.service;

import com.michael.courser.model.Class;
import com.michael.courser.responses.ClassResponse;

public interface ClassService {

    ClassResponse createClass(Class newClass);
    ClassResponse getClassById(String id);
    ClassResponse updateClassById(String id, Class modifiedClass);
    ClassResponse deleteClassById(String id);

    ClassResponse registerClassById(String id);
    ClassResponse deregisterClassById(String id);
}
