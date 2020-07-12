package com.michael.courser.service;

import com.michael.courser.model.Rule;
import com.michael.courser.model.Schedule;

import java.util.List;

public interface ScheduleService {

    Schedule createSchedule(Schedule newSchedule);
    Schedule createScheduleByRules(Integer degreeId, Integer minCredit, Integer maxCredit, List<Rule> rules);
    Schedule getScheduleById(Integer id);
    Schedule updateScheduleById(Integer id, Schedule modifiedSchedule);
    Schedule deleteScheduleById(Integer id);

}
