package com.resume.domain.entity;

import com.resume.domain.request.EduRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Education Entity
 */
@Getter
@Setter
@Entity
@Table(name = "edu_entity")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ename;
    private String estudy;
    private LocalDate sdate;
    private LocalDate edate;
    private String edesc;

    public Education(EduRequestDto eduRequestDto) {
        this.ename = eduRequestDto.getEname();
        this.estudy = eduRequestDto.getEstudy();
        this.sdate = eduRequestDto.getSdate();
        this.edate = eduRequestDto.getEdate();
        this.edesc = eduRequestDto.getEdesc();
    }
}
