package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EmptyEntityException;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.ArrayList;

public class CourseManagement {
    private final ArrayList<Course> courses = new ArrayList<>();
    private final InputValidator inputValidator = new InputValidator();

    public void addCourse(String courseName,String description,int durationInWeeks) throws InvalidInputException {
        if(inputValidator.courseInputValidator(courseName,description)) {
            Course course = new Course(IdGenerator.generateId(), courseName, description, durationInWeeks, true);
            courses.add(course);
            System.out.println("*** Preview ***" + "\n" +
                        course +
                        "Course got created successfully" + "\n");
        }else{
            throw new InvalidInputException("Enter valid course details");
        }
    }

    public void getAllCourses() throws EmptyEntityException {
        if(this.courses.isEmpty()){
           throw new EmptyEntityException("No courses are found");
       }else {
            System.out.println("*** List of all courses ***");
            for (Course course : this.courses) {
                System.out.println(course.toString());
            }
       }
    }

    public void getCourseDetails(int id) throws EntityNotFoundException {
        System.out.println(this.courseById(id));
    }

    public void deactivateCourse(int id) throws EntityNotFoundException {
       Course course = this.courseById(id);
       if(course.isActive()){
           course.setActive(false);
           System.out.println("Course is successfully deactivated");
       }else{
           System.out.println("Course is already deactivated");
       }
    }

    public void activateCourse(int id) throws EntityNotFoundException {
        Course course = this.courseById(id);
        if(course.isActive()){
            System.out.println("Course is already activated");
        }else{
            course.setActive(true);
            System.out.println("Course is successfully activated");
        }
    }

    public Course courseById(int id) throws EntityNotFoundException {
        for(Course course: courses){
            if(id==course.getId()){
                return course;
            }
        }
        throw new EntityNotFoundException("Course not found");
    }
}
