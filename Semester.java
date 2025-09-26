// src/edu/ccrm/domain/Semester.java
package edu.ccrm.domain;

public enum Semester {
    SPRING("Spring", 1),
    SUMMER("Summer", 2),
    FALL("Fall", 3);

    private final String displayName;
    private final int code;

    // Enum constructor
    Semester(String displayName, int code) {
        this.displayName = displayName;
        this.code = code;
    }

    public String getDisplayName() { return displayName; }
    public int getCode() { return code; }

    @Override
    public String toString() {
        return displayName;
    }
}