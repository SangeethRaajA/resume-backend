package com.resume.respository;

import com.resume.domain.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Work Repository
 */
public interface WorkRepository extends JpaRepository<Work, String> {
}
