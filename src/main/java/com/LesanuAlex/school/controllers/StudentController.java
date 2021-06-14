package com.LesanuAlex.school.controllers;

import com.LesanuAlex.school.models.Student;
import com.LesanuAlex.school.models.Teacher;
import com.LesanuAlex.school.repositories.TeacherRepository;
import com.LesanuAlex.school.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final TeacherRepository teacherRepository;
    private final StudentService studentService;


    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/add")
    public Student AddNewStudent(@RequestBody Student newStudent) {
        return studentService.newStudent(newStudent);
    }

    @PutMapping("/modify/{id}")
    public Student replaceStudent(@RequestBody Student newStudent, @PathVariable Long id) {
        return studentService.replaceStudent(newStudent, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deteleStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{studentId}/teachers/{teacherId}")
    Student enrollTeachertoStudent(
            @PathVariable Long studentId,
            @PathVariable Long teacherId
    ) {
        return studentService.enrollTeacherToStudent(studentId, teacherId);
    }
}
