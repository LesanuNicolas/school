package com.LesanuAlex.school.services;

import com.LesanuAlex.school.exceptions.TeacherNotFoundException;
import com.LesanuAlex.school.models.Teacher;
import com.LesanuAlex.school.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Teacher::getId, Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public Teacher getTeacher (Long id) {
        return teacherRepository.findTeacherById(id)
                .orElseThrow(() -> new TeacherNotFoundException(id));
    }

    public Teacher newTeacher(Teacher newTeacher) {
        return teacherRepository.save(newTeacher);
    }

    public Teacher replaceTeacher(Teacher newTeacher, Long id) {
         return teacherRepository.findTeacherById(id)
                .map(teacher -> {
                    teacher.setFirstName(newTeacher.getFirstName());
                    teacher.setLastName(newTeacher.getLastName());
                    teacher.setRole(newTeacher.getRole());
                    return teacherRepository.save(teacher);
                })
                .orElseGet(() -> {
                    newTeacher.setId(id);
                    return teacherRepository.save(newTeacher);
                });
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
