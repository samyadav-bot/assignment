package com.example.Project1.controller;

import com.example.Project1.annotation.LogMethodParam;
import com.example.Project1.constants.ApiUrl;
import com.example.Project1.constants.ServiceStatus;
import com.example.Project1.entity.User;
import com.example.Project1.model.NameDate;
import com.example.Project1.model.UserData;
import com.example.Project1.model.UserFullNameResponse;
import com.example.Project1.service.Processor;
import com.example.Project1.service.UserRelationshipService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class Controller {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Controller.class);
    Logger logger=Logger.getLogger(Controller.class.getName());

    @Autowired
    Processor processor;



    @Autowired
    UserRelationshipService userRelationshipService;



    @GetMapping(ApiUrl.SERVICE_STATUS_URL)
    @Operation(summary = "Get Service status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Service status UP", content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")
    })
    public ResponseEntity<String> serviceStatus(){
        logger.info("Request receive for service status");
        ResponseEntity<String> responseEntity=new ResponseEntity<>(ServiceStatus.UP.name(), HttpStatus.OK);
        return  responseEntity;
    }

    @PostMapping(ApiUrl.USER_FULL_NAME)
    @LogMethodParam
    @Operation(summary = "User greeting  ", description = "User name with greeting")

    public ResponseEntity<UserFullNameResponse> processRequest(@RequestBody NameDate nameDate) throws JsonProcessingException {
        UserFullNameResponse userCompleteName = processor.getUserCompleteName(nameDate);
        ResponseEntity<UserFullNameResponse> responseEntity=new ResponseEntity<>(userCompleteName, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping(ApiUrl.USER_RELATION)
    @LogMethodParam
    @Operation(summary = "user relationship", description = "user relationship")
    public ResponseEntity<List<UserData>> userRelation(){
        List<UserData> userRelationShip = userRelationshipService.getUserRelationShip();
        ResponseEntity<List<UserData>> responseEntity=new ResponseEntity<>(userRelationShip, HttpStatus.OK);
        return  responseEntity;
    }

}
