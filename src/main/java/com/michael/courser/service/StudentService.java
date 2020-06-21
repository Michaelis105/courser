package com.michael.courser.service;

import com.michael.courser.model.Class;

public interface StudentService {

    Class registerClassById(String courseId, String scheduleId);
    Class deregisterClassById(String courseId, String scheduleId);

}
