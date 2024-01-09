package com.resume.domain.entity;

import com.resume.domain.request.ResumeRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

/**
 * Resume Entity
 */
@Getter
@Setter
@Entity
@Table(name = "resume")
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    @Transient
    private static final String RESUME_ID_PREFIX = "rid-";
    @Id
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
    private long createdAt;
    private long updatedAt;

    @ElementCollection
    @CollectionTable(name = "achievements", joinColumns = @JoinColumn(name = "resume_id"))
    @Column(name = "achievement")
    private List<String> achievements;

    @ElementCollection
    @CollectionTable(name = "skills", joinColumns = @JoinColumn(name = "resume_id"))
    @Column(name = "skill")
    private List<String> skills;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resume_id")
    private List<Work> work;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "resume_id")
    private List<Education> edu;

    public Resume(ResumeRequestDto resumeRequestDto) {
        this.id = RESUME_ID_PREFIX + UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        updateResume(resumeRequestDto);
    }

    /**
     * This method updates Resume
     * @param resumeRequestDto updated Resume RequestDto
     */
    public void updateResume(ResumeRequestDto resumeRequestDto) {
        this.firstname = resumeRequestDto.getFirstname();
        this.lastname = resumeRequestDto.getLastname();
        this.title = resumeRequestDto.getTitle();
        this.street = resumeRequestDto.getStreet();
        this.city = resumeRequestDto.getCity();
        this.state = resumeRequestDto.getState();
        this.phone = resumeRequestDto.getPhone();
        this.website = resumeRequestDto.getWebsite();
        this.mail = resumeRequestDto.getMail();
        this.objective = resumeRequestDto.getObjective();
        this.achievements = resumeRequestDto.getAchievements();
        this.skills = resumeRequestDto.getSkills();
        this.work = resumeRequestDto.getWork();
        this.edu = resumeRequestDto.getEdu();
        this.updatedAt = System.currentTimeMillis();
    }
}
