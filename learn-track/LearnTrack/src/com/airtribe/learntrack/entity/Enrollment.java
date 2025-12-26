package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.exception.EntityNotFoundException;

import java.time.LocalDate;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private Status status;
    private Student student;
    private Course course;

    public Enrollment(int id, int studentId, int courseId, LocalDate enrollmentDate, Status status,Student student,Course course) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
        this.student = student;
        this.course = course;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "*** Enrollment Details ***" + "\n"+
                "Id=" + id + "\n"+
                student + "\n"+
                 course + "\n"+
                "EnrollmentDate=" + enrollmentDate +"\n"+
                "Status=" + status +"\n"+
                "*** ***" +"\n";
    }
}
