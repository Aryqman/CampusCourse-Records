// src/edu/ccrm/service/StudentService.java
package edu.ccrm.service;

import edu.ccrm.domain.Student;
import edu.ccrm.domain.Searchable;
import java.util.List;
import java.util.Optional;

public interface StudentService extends Searchable<Student> {
    void addStudent(Student student) throws IllegalArgumentException;
    Optional<Student> getStudentById(String id);
    Optional<Student> getStudentByRegNo(String regNo);
    List<Student> getAllStudents();
    List<Student> getActiveStudents();
    void updateStudent(Student student) throws IllegalArgumentException;
    void deactivateStudent(String id);
    boolean studentExists(String id);
    
    @Override
    List<Student> search(String query);
}