package org.techism.monitoring.controller;

import static com.jayway.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.techism.monitoring.App;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration 
@SpringApplicationConfiguration(classes = App.class)
@IntegrationTest("server.port:0") 
public class MonitoringDataControllerIntegrationTest {
	
	@Value("${local.server.port}")
    int port;
	
	@Test
	public void getStatus_should_return_200(){
		given().port(port).get("monitoring/status").then().
        statusCode(HttpStatus.SC_OK);
	}

	@Test
	public void check_should_return_200(){
        given().port(port).put("monitoring/check").then()
                .
        statusCode(HttpStatus.SC_OK);
	}
	
}
