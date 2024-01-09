package com.resume.respository;

import com.resume.domain.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Edu Repository
 */
public interface EduRepository extends JpaRepository<Education, String> {
}
