package com.michael.courser.service;

import com.michael.courser.responses.StudentResponse;

public interface StudentService {

    StudentResponse getStudentSchedule(String scheduleId);
    StudentResponse registerClassById(String courseId, String scheduleId);
    StudentResponse deregisterClassById(String courseId, String scheduleId);

}
