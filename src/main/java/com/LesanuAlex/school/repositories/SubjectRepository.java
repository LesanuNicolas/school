package com.LesanuAlex.school.repositories;

import com.LesanuAlex.school.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

    Optional<Subject> findSubjectById(Long id);
}
