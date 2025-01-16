package com.example.Project3.controller;


import com.example.Project3.model.ConcatinatedResponse;
import com.example.Project3.model.NameDate;
import com.example.Project3.model.NameDateDto;
import com.example.Project3.service.NameProcessor;
import org.slf4j.MDC;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

@RestController
public class Controller {

    Logger logger=Logger.getLogger(Controller.class.getName());

    @Autowired
    NameProcessor nameProcessor;

    @PostMapping(ApiUrl.SIMPLIFIED_NAMING_API)
    public ResponseEntity<ConcatinatedResponse> processRequest(@RequestBody NameDate nameDate, @RequestHeader Map<String, String> headers){
        MDC.put("traceId", headers.get("traceparent"));
        logger.info("Request receive={}"+nameDate.toString());
        NameDateDto nameDateDto=new NameDateDto();
        BeanUtils.copyProperties(nameDate,nameDateDto);
        ResponseEntity<ConcatinatedResponse> responseEntity=new ResponseEntity<>(nameProcessor.concatenatedName(nameDateDto), HttpStatus.OK);
        return  responseEntity;
    }
}
