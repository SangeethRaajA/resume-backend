package com.resume.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Edu RequestDto
 */
@Getter
@Setter
@AllArgsConstructor
public class EduRequestDto implements RequestDto {
    private String ename;
    private String estudy;
    private LocalDate sdate;
    private LocalDate edate;
    private String edesc;

    /**
     *  this method checks is Required Fields Available
     * @return True/False
     */
    @Override
    public boolean isRequiredFieldsAvailable() {
        return isNonEmpty(ename) && isNonEmpty(estudy);
    }
}
