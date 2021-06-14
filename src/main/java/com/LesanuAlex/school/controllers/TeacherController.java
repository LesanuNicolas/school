package com.LesanuAlex.school.controllers;

import com.LesanuAlex.school.models.Student;
import com.LesanuAlex.school.models.Teacher;
import com.LesanuAlex.school.services.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/all")
    public List<Teacher> getAllTeachers() {

        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherService.getTeacher(id);
    }

    @PostMapping("/add")
    public Teacher AddNewTeacher(@RequestBody Teacher newTeacher) {
        return teacherService.newTeacher(newTeacher);
    }

    @PutMapping("/modify/{id}")
    public Teacher replaceTeacher(@RequestBody Teacher newTeacher, @PathVariable Long id) {
        return teacherService.replaceTeacher(newTeacher, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deteleTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
