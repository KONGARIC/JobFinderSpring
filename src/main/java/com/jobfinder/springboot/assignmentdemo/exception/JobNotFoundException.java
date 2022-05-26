package com.jobfinder.springboot.assignmentdemo.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;


public class JobNotFoundException extends RuntimeException{
    public JobNotFoundException(String message) {
        super(message);
    }

    public JobNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public JobNotFoundException(Throwable cause) {
        super(cause);
    }
}
