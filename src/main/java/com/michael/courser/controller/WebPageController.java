package com.michael.courser.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Routes to dashboard or other miscellaneous services
 */
@CrossOrigin
@Controller
@Api(description = "Set of endpoints for viewing dashboards or other webpages")
public class WebPageController {

    private final Logger _log = LoggerFactory.getLogger(WebPageController.class);

    String indexPageFilename = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Renders UI")
    public String index() {
        _log.trace("Retrieving SPA...");
        return indexPageFilename;
    }
}