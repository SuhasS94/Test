package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorObject> handleException(ResourceNotFoundException e){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.NO_CONTENT.value());
        errorObject.setMsg("UserName Required");
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorObject> handleException(HeaderNotFoundException e){
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorObject.setMsg("Incorrect Header");
        return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.OK);
    }
}
