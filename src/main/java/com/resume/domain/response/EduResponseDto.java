package com.resume.domain.response;

import com.resume.domain.entity.Education;
import lombok.Getter;

import java.time.LocalDate;

/**
 * Edu ResponseDto
 */
@Getter

public class EduResponseDto implements ResponseDto {
    private String ename;
    private String estudy;
    private LocalDate sdate;
    private LocalDate edate;
    private String edesc;

    public EduResponseDto(Education eduData) {
        this.ename = eduData.getEname();
        this.estudy = eduData.getEstudy();
        this.sdate = eduData.getSdate();
        this.edate = eduData.getEdate();
        this.edesc = eduData.getEdesc();
    }
}
