package com.LesanuAlex.school.services;

import com.LesanuAlex.school.exceptions.SubjectNotFoundException;
import com.LesanuAlex.school.models.Subject;
import com.LesanuAlex.school.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubject (Long id) {
        return subjectRepository.findSubjectById(id)
                .orElseThrow(() -> new SubjectNotFoundException(id));
    }

    public Subject newSubject(Subject newSubject) {
        return subjectRepository.save(newSubject);
    }

    public Subject replaceSubject(Subject newSubject, Long id) {
        return (subjectRepository.findSubjectById(id)
                .map(subject -> {
                    subject.setName(newSubject.getName());
                    return subjectRepository.save(subject);
                })
                .orElseGet(() -> {
                    newSubject.setId(id);
                    return subjectRepository.save(newSubject);
                }));
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
}
