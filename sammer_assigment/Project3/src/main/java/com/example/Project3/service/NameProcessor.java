package com.example.Project3.service;

import com.example.Project3.model.ConcatinatedResponse;
import com.example.Project3.model.NameDateDto;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class NameProcessor {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(NameProcessor.class);
    Logger logger=Logger.getLogger(NameProcessor.class.getName());

    public ConcatinatedResponse concatenatedName(NameDateDto nameDateDto){
        logger.info("Process data ="+ nameDateDto.toString());
        ConcatinatedResponse concatinatedResponse=new ConcatinatedResponse();
        concatinatedResponse.setResult( nameDateDto.getName().concat(" ").concat(nameDateDto.getSurname()));
        return concatinatedResponse;
    }
}
