package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EmptyEntityException;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.ArrayList;

public class StudentManagement {
    private final ArrayList<Student> students = new ArrayList<>();
    private final InputValidator inputValidator = new InputValidator();

    public void addStudent(String firstName, String lastName, String email, String batch) throws InvalidInputException {
        if(inputValidator.studentInputValidator(firstName,lastName,email)) {
            Student student = new Student(IdGenerator.generateId(), firstName, lastName, email, batch, true);
            students.add(student);
            System.out.println("*** Preview ***" + "\n" +
                    student +
                    "Student got created successfully");
        }else{
            throw new InvalidInputException("Enter valid student details");
        }
    }

    public void getAllStudents() throws EmptyEntityException {
        if(students.isEmpty()){
            throw new EmptyEntityException("No students are found");
        }else {
            System.out.println("*** List of all students ***");
            for (Student student : students) {
                System.out.println(student.toString());
            }
        }
    }

    public void getStudentDetails(int id) throws EntityNotFoundException {
        System.out.println(this.studentById(id));
    }

    public void deactivateStudent(int id) throws EntityNotFoundException {
        Student student = this.studentById(id);
        if(student.getActive()){
            student.setActive(false);
            System.out.println("Student got deactivated");
        }else{
            System.out.println("Student is already active");
        }
    }

    public Student studentById(int id) throws EntityNotFoundException {
        for(Student student: students){
            if (id == student.getId()) {
                return student;
            }
        }
        throw new EntityNotFoundException("Student not found");
    }
}
