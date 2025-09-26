// src/edu/ccrm/Main.java
package edu.ccrm;

import edu.ccrm.cli.CLIMenu;
import edu.ccrm.config.AppConfig;

/**
 * Main class for Campus Course & Records Manager
 * Demonstrates Java SE application structure and features
 */
public class Main {
    public static void main(String[] args) {
        // Enable assertions
        boolean assertionsEnabled = false;
        assert assertionsEnabled = true;
        
        if (!assertionsEnabled) {
            System.out.println("Warning: Assertions are disabled. Enable with -ea VM option");
        }
        
        try {
            // Demonstrate various Java constructs
            demonstrateJavaFeatures();
            
            // Start the application
            CLIMenu menu = new CLIMenu();
            menu.start();
            
        } catch (Exception e) {
            System.err.println("Fatal error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static void demonstrateJavaFeatures() {
        // Demonstrate loops
        System.out.println("Demonstrating loops:");
        
        // Traditional for loop
        for (int i = 0; i < 3; i++) {
            System.out.println("For loop iteration: " + i);
        }
        
        // Enhanced for loop
        String[] items = {"Item1", "Item2", "Item3"};
        for (String item : items) {
            System.out.println("Enhanced for: " + item);
        }
        
        // While loop with break/continue
        int count = 0;
        while (count < 5) {
            count++;
            if (count == 2) continue; // Skip 2
            if (count == 4) break;    // Stop at 4
            System.out.println("While loop: " + count);
        }
        
        // Do-while loop
        int x = 0;
        do {
            System.out.println("Do-while: " + x);
            x++;
        } while (x < 2);
    }
}