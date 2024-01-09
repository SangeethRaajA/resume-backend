package com.resume.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Work RequestDto
 */
@Getter
@Setter
@AllArgsConstructor
public class WorkRequestDto implements RequestDto {

    private String wname;
    private String role;
    private LocalDate sdate;
    private LocalDate edate;
    private String wdesc;

    /**
     *  this method checks is Required Fields Available
     * @return True/False
     */
    @Override
    public boolean isRequiredFieldsAvailable() {
        return isNonEmpty(wname) && isNonEmpty(role);
    }
}
