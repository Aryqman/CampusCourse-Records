// src/edu/ccrm/cli/CLIMenu.java
package edu.ccrm.cli;

import edu.ccrm.domain.*;
import edu.ccrm.service.*;
import edu.ccrm.service.impl.*;
import edu.ccrm.io.*;
import edu.ccrm.util.exceptions.*;
import edu.ccrm.config.AppConfig;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CLIMenu {
    private final StudentService studentService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final FileImportExportService fileService;
    private final BackupService backupService;
    private final Scanner scanner;
    private boolean running;
    
    public CLIMenu() {
        this.studentService = new StudentServiceImpl();
        this.courseService = new CourseServiceImpl();
        this.enrollmentService = new EnrollmentServiceImpl(studentService, courseService);
        this.fileService = new FileImportExportService(studentService, courseService);
        this.backupService = new BackupService(fileService);
        this.scanner = new Scanner(System.in);
        this.running = true;
    }
    
    public void start() {
        System.out.println("=== Campus Course & Records Manager (CCRM) ===");
        System.out.println("Loading configuration...");
        
        // Demonstrate Singleton pattern
        AppConfig config = AppConfig.getInstance();
        System.out.println("Configuration loaded: " + config);
        
        mainLoop: while (running) {
            displayMainMenu();
            String choice = scanner.nextLine().trim();
            
            // Enhanced switch expression (Java 14+)
            switch (choice) {
                case "1" -> manageStudents();
                case "2" -> manageCourses();
                case "3" -> manageEnrollments();
                case "4" -> manageGrades();
                case "5" -> importExportData();
                case "6" -> backupOperations();
                case "7" -> generateReports();
                case "8" -> displayJavaPlatformInfo();
                case "0" -> { 
                    System.out.println("Goodbye!");
                    running = false;
                }
                case "debug" -> { 
                    demonstrateTechnicalRequirements();
                    continue mainLoop; // Using labeled continue
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
    
    private void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Manage Enrollments");
        System.out.println("4. Manage Grades");
        System.out.println("5. Import/Export Data");
        System.out.println("6. Backup Operations");
        System.out.println("7. Generate Reports");
        System.out.println("8. Java Platform Info");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private void manageStudents() {
        studentMenu: while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT ===");
            System.out.println("1. Add Student");
            System.out.println("2. List All Students");
            System.out.println("3. Search Students");
            System.out.println("4. Update Student");
            System.out.println("5. Deactivate Student");
            System.out.println("6. Print Student Profile");
            System.out.println("0. Back to Main Menu");
            System.out.print("Enter your choice: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1" -> addStudent();
                case "2" -> listStudents();
                case "3" -> searchStudents();
                case "4" -> updateStudent();
                case "5" -> deactivateStudent();
                case "6" -> printStudentProfile();
                case "0" -> { break studentMenu; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    
    private void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            String id = scanner.nextLine().trim();
            System.out.print("Enter Registration Number: ");
            String regNo = scanner.nextLine().trim();
            System.out.print("Enter Full Name: ");
            String fullName = scanner.nextLine().trim();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine().trim();
            
            Student student = new Student(id, regNo, fullName, email);
            studentService.addStudent(student);
            
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }
    
    private void listStudents() {
        List<Student> students = studentService.getAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        // Using Streams and method reference
        students.stream()
            .map(Student::toString)
            .forEach(System.out::println);
    }
    
    private void searchStudents() {
        System.out.print("Enter search term: ");
        String query = scanner.nextLine().trim();
        
        List<Student> results = studentService.search(query);
        if (results.isEmpty()) {
            System.out.println("No students found matching: " + query);
            return;
        }
        
        System.out.println("Found " + results.size() + " student(s):");
        results.forEach(student -> System.out.println(" - " + student.getFullName() + " (" + student.getRegNo() + ")"));
    }
    
    // ... Similar implementations for other menu options
    
    private void demonstrateTechnicalRequirements() {
        System.out.println("\n=== DEMONSTRATING TECHNICAL REQUIREMENTS ===");
        
        // Demonstrate operators and precedence
        demonstrateOperators();
        
        // Demonstrate arrays and utilities
        demonstrateArrays();
        
        // Demonstrate strings
        demonstrateStrings();
        
        // Demonstrate lambdas and functional interfaces
        demonstrateLambdas();
        
        // Demonstrate anonymous inner class
        demonstrateAnonymousInnerClass();
    }
    
    private void demonstrateOperators() {
        System.out.println("\n--- Operators and Precedence ---");
        
        int a = 10, b = 5, c = 2;
        // Demonstrating operator precedence: * before +, && before ||
        boolean result = a + b * c > 20 && b < 10 || c > 1;
        System.out.printf("Expression: a + b * c > 20 && b < 10 || c > 1%n");
        System.out.printf("With a=%d, b=%d, c=%d: result=%b%n", a, b, c, result);
        
        // Bitwise operators
        int x = 5, y = 3;
        System.out.printf("Bitwise: %d & %d = %d, %d | %d = %d%n", 
                         x, y, x & y, x, y, x | y);
    }
    
    private void demonstrateArrays() {
        System.out.println("\n--- Arrays and Utilities ---");
        
        String[] courseCodes = {"CS101", "MATH201", "PHY301", "ENG101"};
        System.out.println("Original array: " + Arrays.toString(courseCodes));
        
        // Sorting with Arrays utility
        Arrays.sort(courseCodes);
        System.out.println("Sorted array: " + Arrays.toString(courseCodes));
        
        // Binary search
        int index = Arrays.binarySearch(courseCodes, "MATH201");
        System.out.println("Index of 'MATH201': " + index);
    }
    
    private void demonstrateStrings() {
        System.out.println("\n--- String Operations ---");
        
        String fullName = "John David Smith";
        String[] names = fullName.split(" ");
        System.out.println("Split name: " + Arrays.toString(names));
        System.out.println("Substring (0,4): " + fullName.substring(0, 4));
        System.out.println("Uppercase: " + fullName.toUpperCase());
        System.out.println("Joined with hyphen: " + String.join("-", names));
    }
    
    private void demonstrateLambdas() {
        System.out.println("\n--- Lambdas and Functional Interfaces ---");
        
        List<Student> students = Arrays.asList(
            new Student("S1", "REG001", "Alice Johnson", "alice@email.com"),
            new Student("S2", "REG002", "Bob Smith", "bob@email.com"),
            new Student("S3", "REG003", "Charlie Brown", "charlie@email.com")
        );
        
        // Lambda comparator for sorting
        students.sort((s1, s2) -> s1.getFullName().compareTo(s2.getFullName()));
        System.out.println("Students sorted by name:");
        students.forEach(s -> System.out.println(" - " + s.getFullName()));
        
        // Predicate for filtering
        Predicate<Student> nameStartsWithA = s -> s.getFullName().startsWith("A");
        List<Student> filtered = students.stream()
            .filter(nameStartsWithA)
            .collect(Collectors.toList());
        System.out.println("Students with names starting with 'A': " + filtered.size());
    }
    
    private void demonstrateAnonymousInnerClass() {
        System.out.println("\n--- Anonymous Inner Class ---");
        
        // Anonymous inner class for a simple task
        Runnable backupTask = new Runnable() {
            @Override
            public void run() {
                System.out.println("Performing backup via anonymous inner class...");
                backupService.createBackup();
            }
        };
        
        // Execute the task
        backupTask.run();
    }
    
    private void displayJavaPlatformInfo() {
        System.out.println("\n=== JAVA PLATFORM INFORMATION ===");
        System.out.println("Java SE vs ME vs EE Comparison:");
        System.out.println("SE (Standard Edition): Desktop, server applications");
        System.out.println("ME (Micro Edition): Mobile, embedded systems");
        System.out.println("EE (Enterprise Edition): Large-scale, distributed systems");
        System.out.println("\nCurrent JVM: " + System.getProperty("java.version"));
    }
}