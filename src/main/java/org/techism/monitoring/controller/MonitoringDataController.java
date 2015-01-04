package org.techism.monitoring.controller;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.techism.monitoring.domain.PageCheck;
import org.techism.monitoring.service.PageCheckService;

@Controller
@EnableAutoConfiguration
@RequestMapping("/monitoring")
public class MonitoringDataController {

    @Autowired
    PageCheckService checkService;

    @RequestMapping(method = RequestMethod.POST, value = "add")
    @ResponseBody
    void addPage() {
        // TODO
        throw new NotImplementedException("");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "check")
    @ResponseBody
    String checkPages() {
        return checkService.check();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "reset")
    @ResponseBody
    void resetPage() {
        // TODO
        throw new NotImplementedException("");
    }

    @RequestMapping(method = RequestMethod.GET, value = "status")
    @ResponseBody
    List<PageCheck> statusPages() {
        return checkService.getStatus();
    }
}