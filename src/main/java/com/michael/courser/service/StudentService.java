package com.michael.courser.service;

import com.michael.courser.model.Class;
import com.michael.courser.model.Schedule;

public interface StudentService {

    Schedule getStudentSchedule(String scheduleId);

    Class registerClassById(String courseId, String scheduleId);
    Class deregisterClassById(String courseId, String scheduleId);

}
