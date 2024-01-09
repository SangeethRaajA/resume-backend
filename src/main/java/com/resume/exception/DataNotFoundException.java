package com.resume.exception;

public class DataNotFoundException extends SimpleResumeApplicationException {
    public DataNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}