package com.example.Project1.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Arrays;

@Aspect
@Component
public class LogMethodParamAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogMethodParamAspect.class);

    @Before("@annotation(com.example.Project1.annotation.LogMethodParam)")
    public void logMethodParams(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        if (args == null || args.length == 0) {
            logger.info("{}.{}() - No arguments", className, methodName);
        } else {
            String argsString = Arrays.toString(args);
            logger.info("{}.{}() - Arguments: {}", className, methodName, argsString);
        }
    }
}