package com.example.demo.config;


import com.example.demo.entity.DataResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AopConfig {

    private final Logger log= LoggerFactory.getLogger(AopConfig.class);

    @Before(value = "execution(* com.example.demo.controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint){
        log.info("Executing {}",joinPoint);
    }

    @After(value = "execution(* com.example.demo.controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint){
        log.info("Closing {}",joinPoint);
    }

    @Around(value = "execution(* com.example.demo.controller.*.*(..))")
    public Object taskHandler(ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        Long startTime = System.currentTimeMillis();
        try{
            Object obj = proceedingJoinPoint.proceed();
            Long timetaken = System.currentTimeMillis()-startTime;
            log.info("Time taken by {} is {}",proceedingJoinPoint,timetaken);
            return obj;
        } catch (DataResponse e) {
            log.error(e.getMessage());
            log.info(e.getStatusCode().toString());
        }return null;
    }
}