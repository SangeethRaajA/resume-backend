package com.resume.exception;

/**
 * InvalidHotelException
 */
public class InvalidResumeException extends SimpleResumeApplicationException{
    public InvalidResumeException(String errorMessage) {
        super(errorMessage);
    }
}