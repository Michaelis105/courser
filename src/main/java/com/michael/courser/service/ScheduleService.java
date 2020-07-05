package com.michael.courser.service;

import com.michael.courser.model.Schedule;

public interface ScheduleService {

    Schedule createSchedule(Schedule newSchedule);
    Schedule getScheduleById(Integer id);
    Schedule updateScheduleById(Integer id, Schedule modifiedSchedule);
    Schedule deleteScheduleById(Integer id);

}
