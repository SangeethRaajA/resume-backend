package com.resume.respository;

import com.resume.domain.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Resume Repository
 */
public interface ResumeRepository extends JpaRepository<Resume, String> {
}