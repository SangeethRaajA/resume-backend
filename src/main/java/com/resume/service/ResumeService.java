package com.resume.service;

import com.resume.domain.entity.Resume;
import com.resume.domain.request.ResumeRequestDto;
import com.resume.domain.request.UpdateResumeRequestDto;
import com.resume.exception.DataNotFoundException;
import com.resume.respository.ResumeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Resume Service
 */
@Service
@Slf4j
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    /**
     * This method is used to save Resume.
     *
     * @param resumeRequestDto resumeRequestDto
     */
    public void saveResume(ResumeRequestDto resumeRequestDto) {
        try {
            Resume resume = new Resume(resumeRequestDto);
            resumeRepository.save(resume);
            log.debug("Successfully added resume.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method find resume by ID
     *
     * @param id resumeId
     * @return ResumeEntity
     */
    public Resume getResumeById(String id) {
        return resumeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Resume not found for id: " + id));
    }

    /**
     * This method updates Resume
     *
     * @param updateResumeRequestDto UpdateResumeRequestDto
     */
    public void updateResume(UpdateResumeRequestDto updateResumeRequestDto) {
        Resume resume = getResumeById(updateResumeRequestDto.getId());
        resume.updateResume(updateResumeRequestDto);
        resumeRepository.save(resume);
        log.debug("Successfully updated resume data.");
    }

    /**
     * This method list all the Resume
     *
     * @return ResumeResponseDto
     */
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    /**
     * This method deletes resume by ID
     *
     * @param id resumeId
     */
    public void deleteResume(String id) {
        var resume = getResumeById(id);
        resumeRepository.delete(resume);
        log.info("Successfully deleted the resume by id: {}", id);
    }
}
