package com.LesanuAlex.school.controllers;

import com.LesanuAlex.school.models.Subject;
import com.LesanuAlex.school.services.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping("/all")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) {
        return subjectService.getSubject(id);
    }

    @PostMapping("/add")
    public Subject AddNewSubject(@RequestBody Subject newSubject) {
        return subjectService.newSubject(newSubject);
    }

    @PutMapping("/modify/{id}")
    public Subject replaceSubject(@RequestBody Subject newSubject, @PathVariable Long id) {
        return subjectService.replaceSubject(newSubject, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deteleSubject(@PathVariable Long id) {
       subjectService.deleteSubject(id);
    }

    @PostMapping("/upload")
    public void saveSubjects() {
        subjectService.saveSubjects();
    }
}
