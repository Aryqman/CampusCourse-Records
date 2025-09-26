// src/edu/ccrm/domain/Grade.java
package edu.ccrm.domain;

public enum Grade {
    S("S", 10.0, "Outstanding"),
    A("A", 9.0, "Excellent"),
    B("B", 8.0, "Very Good"),
    C("C", 7.0, "Good"),
    D("D", 6.0, "Average"),
    E("E", 5.0, "Pass"),
    F("F", 0.0, "Fail");

    private final String letter;
    private final double points;
    private final String description;

    Grade(String letter, double points, String description) {
        this.letter = letter;
        this.points = points;
        this.description = description;
    }

    public String getLetter() { return letter; }
    public double getPoints() { return points; }
    public String getDescription() { return description; }

    public static Grade fromPoints(double points) {
        if (points >= 9.5) return S;
        if (points >= 8.5) return A;
        if (points >= 7.5) return B;
        if (points >= 6.5) return C;
        if (points >= 5.5) return D;
        if (points >= 4.5) return E;
        return F;
    }

    @Override
    public String toString() {
        return String.format("%s (%.1f points) - %s", letter, points, description);
    }
}