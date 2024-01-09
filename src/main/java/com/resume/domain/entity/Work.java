package com.resume.domain.entity;

import com.resume.domain.request.WorkRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Work Entity
 */
@Getter
@Setter
@Entity
@Table(name = "work_entity")
@NoArgsConstructor
@AllArgsConstructor
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String wname;
    private String role;
    private LocalDate sdate;
    private LocalDate edate;
    private String wdesc;

    public Work(WorkRequestDto workRequestDto) {
        this.wname = workRequestDto.getWname();
        this.role = workRequestDto.getRole();
        this.sdate = workRequestDto.getSdate();
        this.edate = workRequestDto.getEdate();
        this.wdesc = workRequestDto.getWdesc();
    }
}
