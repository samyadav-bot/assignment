package com.example.Project1.service;


import com.example.Project1.annotation.LogMethodParam;
import com.example.Project1.config.Service2AppProperties;
import com.example.Project1.config.Service3AppProperties;
import com.example.Project1.model.ConcatinatedResponse;
import com.example.Project1.model.NameDate;
import com.example.Project1.model.UserFullNameResponse;
import com.example.Project1.util.URLUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class Processor {

    Logger logger = Logger.getLogger(Processor.class.getName());

    final ObjectMapper objectMapper = new ObjectMapper();

    RestTemplate restTemplate=new RestTemplate();

    @Autowired
    Service2AppProperties appProperties;
    @Autowired
    Service3AppProperties service3AppProperties;


    @LogMethodParam
    public UserFullNameResponse getUserCompleteName(NameDate nameDate) throws JsonProcessingException {
        String dataFromService2 = getDataForUserFromService2();
        ConcatinatedResponse concatinatedResponse = postDataForUserFromService3(nameDate);
        UserFullNameResponse userFullNameResponse = new UserFullNameResponse();
        userFullNameResponse.setUserFullName(dataFromService2.concat(" ").concat(concatinatedResponse.getResult()));
        return userFullNameResponse;

    }


    public String getDataForUserFromService2() {
        String url = URLUtility.getURLString(appProperties.getHost(), appProperties.getPort(), appProperties.getCallingEndPoint());
        logger.info("service2 calling url= " + url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("traceparent", MDC.get("traceId"));
        HttpEntity<String> request = new HttpEntity<>( headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,request, String.class);
        logger.info("Response receive from service2 Response= " + response);
        return response.getBody();
    }

    public ConcatinatedResponse postDataForUserFromService3(NameDate nameDate) throws JsonProcessingException {
        String url = URLUtility.getURLString(service3AppProperties.getHost(), service3AppProperties.getPort(), service3AppProperties.getCallingEndPoint());
        logger.info("service3 calling url= " + url);
        String requestBody = objectMapper.writeValueAsString(nameDate);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("traceparent", MDC.get("traceId"));
        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        ConcatinatedResponse response = restTemplate.postForObject(url, request, ConcatinatedResponse.class);
        logger.info("Response receive from service3 Response= " + response);
        return response;

    }

}
