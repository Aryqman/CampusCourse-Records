// src/edu/ccrm/domain/Person.java
package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Person {
    protected String id;
    protected String fullName;
    protected String email;
    protected LocalDate createdDate;
    protected boolean active;

    public Person(String id, String fullName, String email) {
        this.id = Objects.requireNonNull(id, "ID cannot be null");
        this.fullName = Objects.requireNonNull(fullName, "Full name cannot be null");
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.createdDate = LocalDate.now();
        this.active = true;
    }
    
    public abstract String getProfileInfo();
    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getCreatedDate() { return createdDate; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Email: %s", id, fullName, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
