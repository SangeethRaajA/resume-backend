package com.resume.domain.response;

import com.resume.domain.entity.Education;
import com.resume.domain.entity.Resume;
import com.resume.domain.entity.Work;
import lombok.Getter;

import java.util.List;

/**
 * Resume ResponseDto
 */
@Getter
public class ResumeResponseDto implements ResponseDto {
    private String id;
    private String firstname;
    private String lastname;
    private String title;
    private String street;
    private String city;
    private String state;
    private String phone;
    private String website;
    private String mail;
    private String objective;
    private List<Work> work;
    private List<Education> edu;
    private List<String> achievements;
    private List<String> skills;
    private long createdAt;
    private long updatedAt;
    public ResumeResponseDto(Resume resume) {
        this.id = resume.getId();
        this.firstname = resume.getFirstname();
        this.lastname = resume.getLastname();
        this.title = resume.getTitle();
        this.street = resume.getStreet();
        this.city = resume.getCity();
        this.state = resume.getState();
        this.phone = resume.getPhone();
        this.website = resume.getWebsite();
        this.mail = resume.getMail();
        this.objective = resume.getObjective();
        this.work = resume.getWork();
        this.edu = resume.getEdu();
        this.achievements = resume.getAchievements();
        this.skills = resume.getSkills();
        this.createdAt = resume.getCreatedAt();
        this.updatedAt = resume.getUpdatedAt();
    }
}
