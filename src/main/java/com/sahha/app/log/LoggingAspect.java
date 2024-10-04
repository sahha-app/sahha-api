package com.sahha.app.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static com.sahha.app.constant.AspectConstant.*;
import static com.sahha.app.util.AspectUtil.*;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);


    @Around("execution(* com.sahha.app.controller.BiomarkersController.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = getClassName(joinPoint);
        String methodName = getMethodName(joinPoint);
        StringBuilder args = getMethodArgs(joinPoint);
        Object returnVal = null;

        LOGGER.info(BEFORE_MESSAGE, className, methodName, args);
        try {
            returnVal = joinPoint.proceed();
        } catch (Throwable throwable) {
            LOGGER.error(AFTER_THROW_MESSAGE, throwable, className, methodName, args);
            throw throwable;
        }
        LOGGER.info(AFTER_RETURN_MESSAGE, className, methodName, args, returnVal);

        return returnVal;
    }
}