// src/edu/ccrm/service/EnrollmentService.java
package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Grade;
import edu.ccrm.util.exceptions.DuplicateEnrollmentException;
import edu.ccrm.util.exceptions.MaxCreditLimitExceededException;
import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    Enrollment enrollStudent(Student student, Course course) 
        throws DuplicateEnrollmentException, MaxCreditLimitExceededException;
    void unenrollStudent(Student student, Course course);
    void recordMarks(Enrollment enrollment, double marks) throws IllegalArgumentException;
    Optional<Enrollment> getEnrollment(String enrollmentId);
    List<Enrollment> getEnrollmentsByStudent(Student student);
    List<Enrollment> getEnrollmentsByCourse(Course course);
    List<Enrollment> getCompletedEnrollments(Student student);
    double calculateGPA(Student student);
    boolean isEnrolled(Student student, Course course);
    int getCurrentSemesterCredits(Student student, Course courseToAdd);
}