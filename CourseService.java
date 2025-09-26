// src/edu/ccrm/service/CourseService.java
package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Instructor;
import edu.ccrm.domain.Semester;
import edu.ccrm.domain.Searchable;
import java.util.List;
import java.util.Optional;

public interface CourseService extends Searchable<Course> {
    void addCourse(Course course) throws IllegalArgumentException;
    Optional<Course> getCourseByCode(String code);
    List<Course> getAllCourses();
    List<Course> getActiveCourses();
    void updateCourse(Course course) throws IllegalArgumentException;
    void deactivateCourse(String code);
    boolean courseExists(String code);
    
    // Search and filter methods using Stream API
    List<Course> getCoursesByInstructor(Instructor instructor);
    List<Course> getCoursesByDepartment(String department);
    List<Course> getCoursesBySemester(Semester semester);
    List<Course> getCoursesByCreditsRange(int minCredits, int maxCredits);
    
    @Override
    List<Course> search(String query);
}