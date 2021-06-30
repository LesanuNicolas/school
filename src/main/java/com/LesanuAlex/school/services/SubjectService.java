package com.LesanuAlex.school.services;

import com.LesanuAlex.school.exceptions.SubjectNotFoundException;
import com.LesanuAlex.school.models.Subject;
import com.LesanuAlex.school.repositories.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    String line = "";
    public void saveSubjects() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Subjects.csv"));
            while((line = br.readLine())!=null) {
                String [] data = line.split(",");
                Subject s = new Subject();
                s.setName(data[0]);
                s.setDifficulty(data[1]);
                s.setPeriod(data[2]);
                s.setPart(data[3]);
                s.setColour(data[4]);
                subjectRepository.save(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
