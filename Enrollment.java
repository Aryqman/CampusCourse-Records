// src/edu/ccrm/domain/Enrollment.java
package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Enrollment {
    private final String enrollmentId;
    private final Student student;
    private final Course course;
    private LocalDate enrollmentDate;
    private Double marks;
    private Grade grade;
    private boolean completed;

    public Enrollment(String enrollmentId, Student student, Course course) {
        this.enrollmentId = Objects.requireNonNull(enrollmentId);
        this.student = Objects.requireNonNull(student);
        this.course = Objects.requireNonNull(course);
        this.enrollmentDate = LocalDate.now();
        this.completed = false;
    }

    // Getters
    public String getEnrollmentId() { return enrollmentId; }
    public Student getStudent() { return student; }
    public Course getCourse() { return course; }
    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public Double getMarks() { return marks; }
    public Grade getGrade() { return grade; }
    public boolean isCompleted() { return completed; }

    public void recordMarks(double marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
        this.grade = Grade.fromPoints(marks / 10.0);
        this.completed = true;
    }

    public double getGradePoints() {
        return grade != null ? grade.getPoints() : 0.0;
    }

    @Override
    public String toString() {
        return String.format("Enrollment[ID: %s, Student: %s, Course: %s, Grade: %s]", 
                           enrollmentId, student.getFullName(), course.getTitle(), 
                           grade != null ? grade.getLetter() : "Not Graded");
    }
}