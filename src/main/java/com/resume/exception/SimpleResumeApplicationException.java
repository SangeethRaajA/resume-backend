package com.resume.exception;

public class SimpleResumeApplicationException extends RuntimeException{
    public SimpleResumeApplicationException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }
    public SimpleResumeApplicationException(String errorMessage) {
        super(errorMessage);
    }
}
