// src/edu/ccrm/domain/Instructor.java
package edu.ccrm.domain;

import java.util.Objects;

public class Instructor extends Person {
    private String department;
    private String office;

    public Instructor(String id, String fullName, String email, String department) {
        super(id, fullName, email);
        this.department = Objects.requireNonNull(department, "Department cannot be null");
    }

    @Override
    public String getProfileInfo() {
        return String.format("Instructor Profile - Name: %s, Department: %s, Email: %s", 
                           fullName, department, email);
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getOffice() { return office; }
    public void setOffice(String office) { this.office = office; }

    @Override
    public String toString() {
        return String.format("Instructor[ID: %s, Name: %s, Department: %s]", 
                           id, fullName, department);
    }
}