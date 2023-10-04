package com.vn.devmaster.services.repository;

import com.vn.devmaster.services.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject , Integer> {
}
