package com.michael.courser.service;

import com.michael.courser.model.Class;
import com.michael.courser.model.Schedule;

public interface StudentService {

    Schedule getStudentSchedule(Integer scheduleId);

    Class registerClassById(Integer courseId, Integer scheduleId);
    Class deregisterClassById(Integer courseId, Integer scheduleId);

}
