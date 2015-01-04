package org.techism.monitoring.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@RequestMapping("/collector")
public class EventCollectorController {
	

	@RequestMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

}
