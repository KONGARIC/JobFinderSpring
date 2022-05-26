package com.jobfinder.springboot.assignmentdemo.exception;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class JobRestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler()
    public ResponseEntity<JobNotFoundExceptionResponse> handleException(MethodArgumentTypeMismatchException exe){
        JobNotFoundExceptionResponse error=new JobNotFoundExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exe.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<JobNotFoundExceptionResponse> handleException(Exception exe){
        JobNotFoundExceptionResponse error=new JobNotFoundExceptionResponse(
                HttpStatus.BAD_REQUEST.value(),
                exe.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JobNotFoundException.class})
    public ResponseEntity<JobNotFoundExceptionResponse> handleJobNotFoundExceptionResponse(JobNotFoundException jobNotFoundException){
        JobNotFoundExceptionResponse error=new JobNotFoundExceptionResponse(
                HttpStatus.NOT_FOUND.value(),
                jobNotFoundException.getMessage(),
                System.currentTimeMillis()
        );
        System.out.println("called");
        System.out.println(error);
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }


}
