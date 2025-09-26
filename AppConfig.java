// src/edu/ccrm/config/AppConfig.java
package edu.ccrm.config;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;

/**
 * Singleton pattern implementation for application configuration
 */
public class AppConfig {
    private static AppConfig instance;
    
    private final Path dataDirectory;
    private final Path backupDirectory;
    private final DateTimeFormatter dateFormatter;
    private final int maxCreditsPerSemester;
    
    // Private constructor for Singleton
    private AppConfig() {
        this.dataDirectory = Paths.get("data");
        this.backupDirectory = Paths.get("backups");
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        this.maxCreditsPerSemester = 18;
        
        // Create directories if they don't exist
        createDirectories();
    }
    
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }
    
    private void createDirectories() {
        try {
            java.nio.file.Files.createDirectories(dataDirectory);
            java.nio.file.Files.createDirectories(backupDirectory);
        } catch (java.io.IOException e) {
            System.err.println("Failed to create directories: " + e.getMessage());
        }
    }
    
    // Getters
    public Path getDataDirectory() { return dataDirectory; }
    public Path getBackupDirectory() { return backupDirectory; }
    public DateTimeFormatter getDateFormatter() { return dateFormatter; }
    public int getMaxCreditsPerSemester() { return maxCreditsPerSemester; }
    
    @Override
    public String toString() {
        return String.format("AppConfig[dataDir: %s, backupDir: %s, maxCredits: %d]", 
                           dataDirectory, backupDirectory, maxCreditsPerSemester);
    }
}