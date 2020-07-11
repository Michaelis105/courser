package com.michael.courser.controller;

import com.michael.courser.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/v1/schedule", method = RequestMethod.GET)
    @ApiOperation(value = "Retrieves a list of classes ")
    public ResponseEntity<List<Class>> getScheduleByConditions(@RequestParam(value = "minc", required = false) String minCredit,
                                                               @RequestParam(value = "maxc", required = false) String maxCredit) {
        _log.trace("Enter...");

        // TODO: IMPLEMENT

        _log.trace("Exit...");
        return null;
    }

}
