package com.michael.courser.controller;

import com.michael.courser.model.Rule;
import com.michael.courser.model.Schedule;
import com.michael.courser.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints for various course scheduling APIs
 */
@CrossOrigin
@RestController
@RequestMapping("api")
@Api(description = "Set of endpoints for scheduling courses")
public class SchedulerController {

    private final Logger _log = LoggerFactory.getLogger(SchedulerController.class);

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(value = "/v1/schedule", method = RequestMethod.POST)
    @ApiOperation(value = "Retrieves a list of classes that satisfy user-specified conditions")
    public ResponseEntity<Schedule> getScheduleByDegree(
            @RequestParam(value = "did", required = true) Integer degreeId,
            @RequestParam(value = "mnc", required = false) Integer minCredit,
            @RequestParam(value = "mxc", required = false) Integer maxCredit,
            @RequestBody List<Rule> rules) {
        _log.trace("Enter...");

        Schedule schedule;
        try {
            schedule = scheduleService.createScheduleByRules(degreeId, minCredit, maxCredit, rules);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        _log.trace("Exit...", schedule);
        return (schedule == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(schedule);
    }

}
