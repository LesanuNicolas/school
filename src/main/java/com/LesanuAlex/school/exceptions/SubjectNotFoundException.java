package com.LesanuAlex.school.exceptions;


public class SubjectNotFoundException extends RuntimeException{

    public SubjectNotFoundException(Long id) {
        super("Subject " + id + " not found");
    }
}
