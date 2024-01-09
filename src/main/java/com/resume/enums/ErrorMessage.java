package com.resume.enums;

import lombok.Getter;

/**
 * Error messages.
 */
@Getter
public enum ErrorMessage {

    INTERNAL_SERVER_ERROR("Something went wrong."),
    MISSING_REQUIRED_FIELDS("Required fields are missing."),
    DATA_NOT_FOUND("Data not found."),
    INVALID_RESUME_ID("Invalid resume ID.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
}
