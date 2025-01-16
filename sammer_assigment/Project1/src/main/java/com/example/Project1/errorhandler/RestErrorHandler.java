package com.example.Project1.errorhandler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {

    private static final Logger errorLogger = LoggerFactory.getLogger(RestErrorHandler.class.getName());

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<String> handleRestException(RuntimeException ex) {
        logger.error("Request processing failed ", ex);
        return new ResponseEntity<>("INTERNAL SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
