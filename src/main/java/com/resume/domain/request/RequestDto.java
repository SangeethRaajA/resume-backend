package com.resume.domain.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.resume.exception.SimpleResumeApplicationException;

/**
 * RequestDto
 */
public interface RequestDto {
    /**
     * Used to validate required fields.
     *
     * @return true/false
     */
    boolean isRequiredFieldsAvailable();

    /**
     * This method checks the given field is non-empty.
     *
     * @param field field
     * @return true/ false
     */
    default boolean isNonEmpty(String field) {
        return field != null && !field.trim().isEmpty();
    }

    default String toLogJson() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new SimpleResumeApplicationException("Object to json conversion was failed.", e);
        }
    }

}
