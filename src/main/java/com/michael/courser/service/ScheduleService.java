package com.michael.courser.service;

import com.michael.courser.model.Schedule;

public interface ScheduleService {

    Schedule createSchedule(Schedule newSchedule);
    Schedule getScheduleById(String id);
    Schedule updateScheduleById(String id, Schedule modifiedSchedule);
    Schedule deleteScheduleById(String id);

}
