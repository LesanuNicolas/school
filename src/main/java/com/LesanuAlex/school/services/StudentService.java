package com.LesanuAlex.school.services;

import com.LesanuAlex.school.exceptions.StudentNotFoundException;
import com.LesanuAlex.school.models.Student;
import com.LesanuAlex.school.models.Teacher;
import com.LesanuAlex.school.repositories.StudentRepository;
import com.LesanuAlex.school.repositories.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent (Long id) {
        return studentRepository.findStudentById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    public Student newStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    public Student replaceStudent(Student newStudent, Long id) {
        return studentRepository.findStudentById(id)
                .map(student -> {
                    student.setFirstName(newStudent.getFirstName());
                    student.setLastName(newStudent.getLastName());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student enrollTeacherToStudent(Long studentId, Long teacherId) {
        Student student = studentRepository.findStudentById(studentId).get();
        Teacher teacher = teacherRepository.findTeacherById(teacherId).get();
        student.enrollTeacher(teacher);
        return studentRepository.save(student);
    }
}
