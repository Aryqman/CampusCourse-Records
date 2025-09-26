// src/edu/ccrm/domain/Course.java
package edu.ccrm.domain;

import java.util.Objects;

public class Course implements Persistable {
    private final String code; // Immutable
    private String title;
    private int credits;
    private Instructor instructor;
    private Semester semester;
    private String department;
    private boolean active;

    // Private constructor for Builder
    private Course(Builder builder) {
        this.code = builder.code;
        this.title = builder.title;
        this.credits = builder.credits;
        this.instructor = builder.instructor;
        this.semester = builder.semester;
        this.department = builder.department;
        this.active = true;
    }

    // Builder pattern implementation
    public static class Builder {
        private final String code;
        private String title;
        private int credits;
        private Instructor instructor;
        private Semester semester;
        private String department;

        public Builder(String code) {
            this.code = Objects.requireNonNull(code, "Course code cannot be null");
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder credits(int credits) {
            if (credits <= 0) throw new IllegalArgumentException("Credits must be positive");
            this.credits = credits;
            return this;
        }

        public Builder instructor(Instructor instructor) {
            this.instructor = instructor;
            return this;
        }

        public Builder semester(Semester semester) {
            this.semester = semester;
            return this;
        }

        public Builder department(String department) {
            this.department = department;
            return this;
        }

        public Course build() {
            // Validation
            Objects.requireNonNull(title, "Title cannot be null");
            Objects.requireNonNull(semester, "Semester cannot be null");
            Objects.requireNonNull(department, "Department cannot be null");
            
            if (credits <= 0) throw new IllegalStateException("Credits must be set");
            
            return new Course(this);
        }
    }

    // Getters and setters
    public String getCode() { return code; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }
    public Semester getSemester() { return semester; }
    public void setSemester(Semester semester) { this.semester = semester; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%d,%s,%s,%s,%b", 
                           code, title, credits, 
                           instructor != null ? instructor.getId() : "N/A",
                           semester.name(), department, active);
    }

    @Override
    public String toJSON() {
        return String.format("{\"code\":\"%s\",\"title\":\"%s\",\"credits\":%d,\"instructor\":\"%s\",\"semester\":\"%s\",\"department\":\"%s\",\"active\":%b}",
                           code, title, credits, 
                           instructor != null ? instructor.getId() : "N/A",
                           semester.name(), department, active);
    }

    @Override
    public String toString() {
        return String.format("Course[Code: %s, Title: %s, Credits: %d, Department: %s]", 
                           code, title, credits, department);
    }
}