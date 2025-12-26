package com.airtribe.learntrack.ui;

import com.airtribe.learntrack.entity.Status;
import com.airtribe.learntrack.exception.EmptyEntityException;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.exception.InvalidInputException;
import com.airtribe.learntrack.service.CourseManagement;
import com.airtribe.learntrack.service.EnrollmentManagement;
import com.airtribe.learntrack.service.StudentManagement;

import java.time.LocalDate;
import java.util.Scanner;

public class LearnTrack {
    private static boolean flag = true;
    private static boolean individualFlag = true;
    private static final Scanner scan = new Scanner(System.in);
    private static final StudentManagement studentManagement = new StudentManagement();
    private static final CourseManagement courseManagement = new CourseManagement();
    private static final EnrollmentManagement enrollmentManagement = new EnrollmentManagement();


    public static void main(String[] args) {
        while (flag) {
            try {
                displayManagementMenu();
                String managementSystem = scan.nextLine();
                displayIndividualMenu(Integer.parseInt(managementSystem));
            } catch (InvalidInputException | EntityNotFoundException | EmptyEntityException exception) {
                flag=false;
                System.out.println(exception.getMessage());
            }
        }
    }

    private static void displayManagementMenu() throws InvalidInputException, EntityNotFoundException, EmptyEntityException {
        System.out.println("Choose an option:" + "\n" +
                "1.Student Management System" + "\n" +
                "2.Course Management System" + "\n" +
                "3.Enrollment Management System" + "\n" +
                "4.Exit Management System");
    }

    private static void displayIndividualMenu(int option) throws InvalidInputException, EntityNotFoundException, EmptyEntityException {
        individualFlag = true;
        switch (option) {
            case 1:
                displayStudentManagementSystem();
                break;
            case 2:
                displayCourseManagementSystem();
                break;
            case 3:
                displayEnrollmentManagementSystem();
                break;
            case 4:
                flag = false;
                break;
            default:
                throw new InvalidInputException("Choose a Valid input ");
        }

    }

    private static void displayStudentManagementSystem() throws EntityNotFoundException, InvalidInputException, EmptyEntityException {
        while(individualFlag) {
        System.out.println("*** Welcome to Student Management System ***" + "\n" +
                "Choose an option:" + "\n" +
                "1A.Add student" + "\n" +
                "1B.Get all students" + "\n" +
                "1C.Get student details" + "\n" +
                "1D.Deactivate a student" + "\n" +
                "1E. Exit Student Management System");

            String studentManagementSystem = scan.nextLine();
            studentManagementService(studentManagementSystem);
        }
    }

    private static void displayCourseManagementSystem() throws InvalidInputException, EntityNotFoundException, EmptyEntityException {
        while(individualFlag) {
        System.out.println("*** Welcome to Course Management System ***" + "\n" +
                "Choose an option:" + "\n" +
                "2A.Add course" + "\n" +
                "2B.Get all courses" + "\n" +
                "2C.Get course details" + "\n" +
                "2D.Activate a course" + "\n" +
                "2E.Deactivate a course" + "\n" +
                "2F. Exit Course Management System");

            String option = scan.nextLine();
            courseManagementService(option);
        }
    }

    private static void displayEnrollmentManagementSystem() throws InvalidInputException, EntityNotFoundException, EmptyEntityException {
        while(individualFlag) {
        System.out.println("*** Welcome to Enrollment Management System ***" + "\n" +
                "Choose an option:" + "\n" +
                "3A.Add student enrollment" + "\n" +
                "3B.Get all student enrollments" + "\n" +
                "3C.Mark enrollment" + "\n" +
                "3D. Exit Enrollment Management System");

            String option = scan.nextLine();
            enrollmentManagementService(option);
        }
    }

    private static void studentManagementService(String option) throws EntityNotFoundException, InvalidInputException, EmptyEntityException {
        switch (option) {
            case "1A":
                addStudentDetails();
                break;
            case "1B":
                studentManagement.getAllStudents();
                break;
            case "1C":
                System.out.println("Enter student id:");
                String id = scan.nextLine();
                studentManagement.getStudentDetails(Integer.parseInt(id));
                break;
            case "1D":
                System.out.println("Enter student id:");
                String deactivateId = scan.nextLine();
                studentManagement.deactivateStudent(Integer.parseInt(deactivateId));
                break;
            case "1E":
                System.out.println("Exit Student Management System");
                individualFlag = false;
                break;
            default:
                throw new InvalidInputException("Enter valid student menu option input");
        }
    }

    private static void addStudentDetails() throws InvalidInputException {
        System.out.println("***Enter student details ***");
        System.out.println("Enter first name:");
        String firstName = scan.nextLine();
        System.out.println("Enter last name:");
        String lastName = scan.nextLine();
        System.out.println("Enter email:");
        String email = scan.nextLine();
        System.out.println("Enter batch:");
        String batch = scan.nextLine();
        studentManagement.addStudent(firstName, lastName, email, batch);
    }

    private static void courseManagementService(String option) throws EntityNotFoundException, InvalidInputException, EmptyEntityException {
        switch (option) {
            case "2A":
                addCourse();
                break;
            case "2B":
                courseManagement.getAllCourses();
                break;
            case "2C":
                System.out.println("Enter course id:");
                String id = scan.nextLine();
                courseManagement.getCourseDetails(Integer.parseInt(id));
                break;
            case "2D":
                System.out.println("Enter course id:");
                String activateId = scan.nextLine();
                courseManagement.activateCourse(Integer.parseInt(activateId));
                break;
            case "2E":
                System.out.println("Enter course id:");
                String deactivateId = scan.nextLine();
                courseManagement.deactivateCourse(Integer.parseInt(deactivateId));
                break;
            case "2F":
                System.out.println("Exit Course Management System");
                individualFlag = false;
                break;
            default:
                throw new InvalidInputException("Enter valid course menu option input");
        }
    }

    private static void addCourse() throws InvalidInputException {
        System.out.println("***Enter course details ***");
        System.out.println("Enter course name:");
        String courseName = scan.nextLine();
        System.out.println("Enter description:");
        String description = scan.nextLine();
        System.out.println("Enter duration in weeks:");
        String durationInWeeks = scan.nextLine();
        courseManagement.addCourse(courseName, description, Integer.parseInt(durationInWeeks));
    }

    private static void enrollmentManagementService(String option) throws InvalidInputException, EntityNotFoundException, EmptyEntityException {
        switch (option) {
            case "3A":
                addEnrollment();
                break;
            case "3B":
                System.out.println("Enter student id:");
                String id = scan.nextLine();
                enrollmentManagement.getEnrollmentsForStudents(Integer.parseInt(id));
                break;
            case "3C":
                System.out.println("Enter enrollment id:");
                String markId = scan.nextLine();
                System.out.println("Enter status:");
                String status = scan.nextLine();
                enrollmentManagement.markEnrollment(Integer.parseInt(markId), Status.valueOf(status));
                break;
            case "3D":
                System.out.println("Exit Course Management System");
                individualFlag = false;
                break;
            default:
                throw new InvalidInputException("Enter valid enrollment menu option input");
        }
    }

    private static void addEnrollment() throws EntityNotFoundException, InvalidInputException {
        System.out.println("*** Enter enrollment details ***");
        System.out.println("Enter student Id:");
        String studentId = scan.nextLine();
        System.out.println("Enter course Id:");
        String courseId = scan.nextLine();
        System.out.println("Enter date in yyyy-mm-dd format:");
        String enrollmentDate = scan.nextLine();
        enrollmentManagement.enroll(Integer.parseInt(studentId), Integer.parseInt(courseId), LocalDate.parse(enrollmentDate),studentManagement,courseManagement);
    }
}
