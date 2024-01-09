package com.resume.domain.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateResumeRequestDto extends ResumeRequestDto{
    private String id;
    public boolean isRequiredFieldsAvailableForUpdate() {
        return isNonEmpty(id) && isRequiredFieldsAvailable();
    }

}
