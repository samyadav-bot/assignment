package com.example.Project2.controller;


import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class Controller {

    Logger logger = Logger.getLogger(Controller.class.getName());


    @GetMapping(ApiUrl.HELLO_CALL)
    public ResponseEntity<String> processRequest(@RequestHeader Map<String, String> headers) {
        MDC.put("traceId", headers.get("traceparent"));
        logger.info("Request receive form service 1");
        ResponseEntity<String> responseEntity = new ResponseEntity<>("HELLO", HttpStatus.OK);
        return responseEntity;
    }
}
