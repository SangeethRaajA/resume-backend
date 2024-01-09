package com.resume.enums;

import lombok.Getter;

/**
 * Success messages.
 */
@Getter
public enum SuccessMessage {

    SUCCESSFULLY_ADDED("Successfully added."),
    SUCCESSFULLY_UPDATED("Successfully updated."),
    SUCCESSFULLY_RETURNED("Successfully returned data."),
    SUCCESSFULLY_DELETED("Successfully deleted."),
    READ_RESUME("Successfully returned the resume by id."),
    READ_RESUME_LIST("Successfully returned the resume list."),
    DELETE_RESUME("Successfully delete the resume.");
    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }
}
