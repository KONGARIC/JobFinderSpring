package com.jobfinder.springboot.assignmentdemo.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class JobNotFoundExceptionResponse {
    private int status;
    private String message;
    private long timeStamp;

    public JobNotFoundExceptionResponse(){

    }

    public JobNotFoundExceptionResponse(int status, String message, long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "JobNotFoundExceptionResponse{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
