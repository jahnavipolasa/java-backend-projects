package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Status;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EmptyEntityException;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.time.LocalDate;
import java.util.ArrayList;

public class EnrollmentManagement {
    private final ArrayList<Enrollment> enrollments = new ArrayList<>();
    private final InputValidator inputValidator = new InputValidator();

    public void enroll(int studentId, int courseId, LocalDate enrollmentDate,StudentManagement studentManagement,CourseManagement courseManagement) throws InvalidInputException, EntityNotFoundException {
        Student student = studentManagement.studentById(studentId);
        Course course = courseManagement.courseById(courseId);
        if(student !=null && course !=null && inputValidator.enrollmentInputValidator(student,course,enrollmentDate) ) {
            Enrollment enroll = new Enrollment(IdGenerator.generateId(), studentId, courseId, enrollmentDate, Status.ACTIVE,student,course);
            enrollments.add(enroll);
            System.out.println("*** Preview ***" + "\n" +
                    enroll+
                    "student got enrolled into course successfully"+ "\n");
        }else{
            throw new InvalidInputException("Enter valid enrollment details");
        }
    }

    public void getEnrollmentsForStudents(int studentId) throws EmptyEntityException {
        int count=0;
        System.out.println("Student with id: "+studentId+ " got enrolled in the following courses:");
        for(Enrollment enrollment: enrollments){
            if(enrollment.getStudentId()==studentId){
                System.out.println(enrollment.getCourse());
                count++;
            }
        }
        if(count == 0){
            throw new EmptyEntityException("Student is not enrolled in any course");
        }
    }


    public void markEnrollment(int id,Status status) throws EntityNotFoundException {
        Enrollment enroll =this.getEnrollmentById(id);
        if(status.equals(Status.COMPLETED) || status.equals(Status.CANCELLED)) {
            enroll.setStatus(status);
            System.out.println("Enrollment is marked successfully");
        }else{
            System.out.println("Enrollment is already active");
        }
    }

    private Enrollment getEnrollmentById(int id) throws EntityNotFoundException {
        for(Enrollment enrollment: enrollments){
            if(enrollment.getId()==id){
                return enrollment;
            }
        }
        throw new EntityNotFoundException("Enrollment not found");
    }
}
