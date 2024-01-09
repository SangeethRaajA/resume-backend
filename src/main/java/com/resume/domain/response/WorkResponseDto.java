package com.resume.domain.response;

import com.resume.domain.entity.Work;
import lombok.Getter;

import java.time.LocalDate;

/**
 * Work ResponseDto
 */
@Getter

public class WorkResponseDto implements ResponseDto {
    private String wname;
    private String role;
    private LocalDate sdate;
    private LocalDate edate;
    private String wdesc;

    public WorkResponseDto(Work workData) {
        this.wname = workData.getWname();
        this.role = workData.getRole();
        this.sdate = workData.getSdate();
        this.edate = workData.getEdate();
        this.wdesc = workData.getWdesc();
    }
}
