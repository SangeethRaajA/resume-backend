package com.resume.controller;

import com.resume.configuration.Translator;
import com.resume.domain.request.*;
import com.resume.domain.response.ResponseDto;
import com.resume.domain.response.ResponseWrapper;
import com.resume.domain.response.ResumeListResponseDto;
import com.resume.domain.response.ResumeResponseDto;
import com.resume.enums.*;
import com.resume.exception.InvalidResumeException;
import com.resume.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Resume controller
 */
@RestController
@Slf4j
@RequestMapping("/api/v1/resume")
public class ResumeController extends BaseController {
    @Autowired
    private ResumeService resumeService;

    public ResumeController(Translator translator, ResumeService resumeService) {
        super(translator);
        this.resumeService = resumeService;
    }

    /**
     * This method save Resume
     *
     * @param resumeRequestDto resumeRequestDto
     * @return getSuccessResponse / getBadRequestErrorResponse
     */
    @PostMapping("/save")
    public ResponseEntity<ResponseWrapper> saveResume(@RequestBody ResumeRequestDto resumeRequestDto) {
        if (!resumeRequestDto.isRequiredFieldsAvailable()) {
            log.debug("Required fields missing. data: {}", resumeRequestDto.toLogJson());
            return getBadRequestErrorResponse(ErrorMessage.MISSING_REQUIRED_FIELDS);
        }
        resumeService.saveResume(resumeRequestDto);
        log.debug("Successfully save resume.");
        return getSuccessResponse(SuccessMessage.SUCCESSFULLY_ADDED, null, HttpStatus.CREATED);
    }

    /**
     * This method find resume by ID
     *
     * @param id resumeId
     * @return ResumeResponseDto
     */
    @GetMapping("/{id}")
    public ResponseEntity<ResponseWrapper> getResume(@PathVariable String id) {
        try {
            var resume = resumeService.getResumeById(id);
            var resumeResponseDto = new ResumeResponseDto(resume);
            return getSuccessResponse(SuccessMessage.READ_RESUME, resumeResponseDto, HttpStatus.OK);
        } catch (InvalidResumeException e) {
            log.error("Invalid resume id to get resume details.");
            return getBadRequestErrorResponse(ErrorMessage.INVALID_RESUME_ID);
        }
    }

    /**
     * This method update Resume
     *
     * @param updateResumeRequestDto UpdateResumeRequestDto
     * @return getSuccessResponse / getBadRequestErrorResponse
     */
    @PutMapping("/update")
    public ResponseEntity<ResponseWrapper> updateResume(@RequestBody UpdateResumeRequestDto updateResumeRequestDto) {
        try {
            if (!updateResumeRequestDto.isRequiredFieldsAvailableForUpdate()) {
                log.debug("Required fields missing. data: {}", updateResumeRequestDto.toLogJson());
                return getBadRequestErrorResponse(ErrorMessage.MISSING_REQUIRED_FIELDS);
            }
            resumeService.
                    updateResume(updateResumeRequestDto);
            return getSuccessResponse(SuccessMessage.SUCCESSFULLY_UPDATED, null, HttpStatus.OK);
        } catch (InvalidResumeException e) {
            log.error("Invalid resume id to get resume details.");
            return getBadRequestErrorResponse(ErrorMessage.INVALID_RESUME_ID);
        }
    }

    /**
     * This method list all Resume
     *
     * @return resumeListResponseDto
     */
    @GetMapping("/list")
    public ResponseEntity<ResponseWrapper> getResumeList() {
        var resumeListResponseDto = new ResumeListResponseDto(resumeService.getAllResumes());
        log.debug("Successfully returned all resumes.");
        return getSuccessResponse(SuccessMessage.READ_RESUME_LIST, (ResponseDto) resumeListResponseDto, HttpStatus.OK);
    }

    /**
     * This method deletes resume by ID
     *
     * @param id resumeId
     * @return getSuccessResponse / getBadRequestErrorResponse
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseWrapper> deleteResume(@PathVariable String id) {
        try {
            resumeService.deleteResume(id);
            return getSuccessResponse(SuccessMessage.DELETE_RESUME, null, HttpStatus.OK);
        } catch (InvalidResumeException e) {
            log.error("Invalid resume id to get resume details.");
            return getBadRequestErrorResponse(ErrorMessage.INVALID_RESUME_ID);
        }
    }
}
