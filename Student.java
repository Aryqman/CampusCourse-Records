// src/edu/ccrm/domain/Student.java
package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private final String regNo; 
    private StudentStatus status;
    private final List<Enrollment> enrolledCourses;
    
 
    public static class StudentStatus {
        public static final String ACTIVE = "ACTIVE";
        public static final String INACTIVE = "INACTIVE";
        public static final String GRADUATED = "GRADUATED";
        public static final String SUSPENDED = "SUSPENDED";
    }

    public Student(String id, String regNo, String fullName, String email) {
        super(id, fullName, email);
        this.regNo = Objects.requireNonNull(regNo, "Registration number cannot be null");
        this.status = StudentStatus.ACTIVE;
        this.enrolledCourses = new ArrayList<>();
    }

    @Override
    public String getProfileInfo() {
        return String.format("Student Profile - RegNo: %s, Name: %s, Status: %s, Email: %s", 
                           regNo, fullName, status, email);
    }

  
    public String getRegNo() { return regNo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Enrollment> getEnrolledCourses() { return new ArrayList<>(enrolledCourses); } 

    public void addEnrollment(Enrollment enrollment) {
        enrolledCourses.add(enrollment);
    }

    public void removeEnrollment(Enrollment enrollment) {
        enrolledCourses.remove(enrollment);
    }

    
    @Override
    public String toString() {
        return String.format("Student[ID: %s, RegNo: %s, Name: %s, Status: %s]", 
                           id, regNo, fullName, status);
    }
}
