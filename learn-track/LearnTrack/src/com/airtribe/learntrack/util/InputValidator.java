package com.airtribe.learntrack.util;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;

import java.time.LocalDate;

public class InputValidator {
    private boolean valid = false;

    public boolean studentInputValidator(String firstName, String lastName, String email){
        if(firstName.length()<=30 && lastName.length()<=30 && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")){
            valid=true;
        }
        return valid;
    }

    public boolean courseInputValidator(String courseName,String description){
        if(courseName.length()<=30 && description.length()<=200){
            valid = true;
        }
        return valid;
    }

    public boolean enrollmentInputValidator(Student student, Course course, LocalDate enrollmentDate) {
        if(student.getActive() && course.isActive() && enrollmentDate.isBefore(LocalDate.now())){
            valid = true;
        }
        return valid;
    }
}