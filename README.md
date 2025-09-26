# CampusCourse-Records

## Project Overview
The Campus Course & Records Manager (CCRM) is a comprehensive Java SE console application designed for educational institutions to manage students, courses, enrollments, and academic records. 
This application demonstrates advanced Java programming concepts including OOP principles, design patterns, modern I/O operations, and functional programming.

## Key Features

    Student Management: Create, update, and manage student profiles

    Course Management: Handle course creation, assignment, and scheduling

    Enrollment System: Manage student course registrations with business rules

    Grading System: Record marks, calculate GPA, generate transcripts

    File Operations: Import/export data using CSV formats with NIO.2

    Backup System: Automated timestamped backups with recursive utilities

    Reporting: Generate academic reports using Stream API


## Evolution of Java
### Java Version Timeline

    1996: Java 1.0 - Initial release with basic features

    1997: Java 1.1 - Inner classes, JDBC, RMI

    2000: Java 1.3 - HotSpot JVM, JavaSound

    2004: Java 5 - Generics, annotations, autoboxing, enums

    2014: Java 8 - Lambda expressions, Stream API, Date/Time API

    2017: Java 9 - Module system, JShell

    2018: Java 11 - LTS, HTTP Client, local variable syntax

    2021: Java 17 - LTS, sealed classes, pattern matching

    2023: Java 21 - LTS, virtual threads, record patterns


##Java Architecture: JDK, JRE, JVM
###Components Overview

      ┌─────────────────┐
      │     JDK         │ - Java Development Kit (Development Tools)
      │  ┌─────────────┐│
      │  │     JRE     ││ - Java Runtime Environment (Libraries + JVM)
      │  │  ┌─────────┐││
      │  │  │   JVM   │││ - Java Virtual Machine (Execution Engine)
      │  │  └─────────┘││
      │  └─────────────┘│
      └─────────────────┘

### Syllabus Topic Mapping
    Syllabus Topic	      Implementation Location	                  Demonstration
    OOP Principles		
    Encapsulation	        Person.java,         Student.java	        Private fields with getters/setters
    Inheritance	          Person → Student, Instructor	            Abstract class inheritance
    Abstraction	          Person.java abstract class/methods	      Abstract methods in base class
    Polymorphism	        getProfileInfo() method overriding	      Virtual method invocation
    Design Patterns		
    Singleton	            AppConfig.java	                          Global configuration instance
    Builder	              Course.Builder                            Fluent interface for object creation
    Exception Handling	  edu.ccrm.util.exceptions package	        Custom exceptions, try-catch-finally
    File I/O (NIO.2)	    FileImportExportService.java	            Path, Files, Stream operations
    Stream API	          Service implementations	                  Filtering, mapping, collection operations
    Date/Time             API	Domain classes	                      LocalDate for timestamps
    Lambda Expressions	  CLIMenu.demonstrateLambdas()	            Functional interfaces, comparators
    Collections           Framework	Service implementations	        Lists, Maps, Stream operations
    Generics	            Searchable<T> interface	                  Type-safe collections and methods








### OOP & Type System

● Four pillars:

○ Encapsulation: private fields + getters/setters.

○ Inheritance: e.g., Person (abstract) → Student and Instructor.

○ Abstraction: abstract class Person with abstract methods.

○ Polymorphism: common interface or base-class references to varied subtypes
(virtual method invocation).

● Access levels: use private, protected, default, public meaningfully.

● Types of inheritance and constructors in inheritance; demonstrate super.

● Immutability: one immutable value class (e.g., Name or CourseCode) with final fields
and defensive copying.

● Top-level & nested classes: include one static nested class and one inner class.

● Interfaces:

○ Define at least one interface (e.g., Persistable, Searchable<T>).

○ Show diamond problem resolution via default methods and explicit override.

○ Decide where interface vs class inheritance makes sense (justify briefly in
README).

● Functional interfaces & lambdas: e.g., comparator lambdas for sorting, predicates for
filtering.

● Anonymous inner classes: use once (e.g., custom listener/callback in CLI or a quick
strategy).

● Enums with constructors & fields: Semester, Grade.
Advanced Concepts

● Upcast & downcast, and instanceof checks (justify necessity in comments).

● Overriding & overloading methods; override toString() in domain classes.

● Design patterns:

○ Singleton: AppConfig or DataStore.

○ Builder: Course.Builder or Transcript.Builder.

● Exceptions:

○ Clarify Errors vs Exceptions in README.

○ Use checked & unchecked exceptions;
try/catch/multi-catch/finally/throw/throws.

○ Create at least two custom exceptions (e.g.,
DuplicateEnrollmentException,
MaxCreditLimitExceededException).

○ Use assertions for invariants (e.g., non-null ids, credit bounds) with a README
note on enabling assertions.

● File I/O (NIO.2):

○ Path & Files APIs for check/delete/copy/move.

○ Use Streams to read/write and process lines.

○ Demonstrate a small Stream pipeline that aggregates reports (e.g., GPA
distribution).

● Date/Time API for timestamps (enrollment date, backup folder names)

