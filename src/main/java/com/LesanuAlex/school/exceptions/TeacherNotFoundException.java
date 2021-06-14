package com.LesanuAlex.school.exceptions;

public class TeacherNotFoundException extends RuntimeException{

    public TeacherNotFoundException(Long id) {
        super("Teacher " + id + " not found");
    }
}
