package com.LesanuAlex.school.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(Long id){
        super("Student " + id + " not found");
    }
}
