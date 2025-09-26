// src/edu/ccrm/util/exceptions/DuplicateEnrollmentException.java
package edu.ccrm.util.exceptions;

public class DuplicateEnrollmentException extends Exception {
    public DuplicateEnrollmentException(String message) {
        super(message);
    }
    
    public DuplicateEnrollmentException(String message, Throwable cause) {
        super(message, cause);
    }
}

// src/edu/ccrm/util/exceptions/MaxCreditLimitExceededException.java
package edu.ccrm.util.exceptions;

public class MaxCreditLimitExceededException extends Exception {
    private final int currentCredits;
    private final int attemptedCredits;
    private final int maxCredits;
    
    public MaxCreditLimitExceededException(String message, int currentCredits, int attemptedCredits, int maxCredits) {
        super(message);
        this.currentCredits = currentCredits;
        this.attemptedCredits = attemptedCredits;
        this.maxCredits = maxCredits;
    }
    
    public int getCurrentCredits() { return currentCredits; }
    public int getAttemptedCredits() { return attemptedCredits; }
    public int getMaxCredits() { return maxCredits; }
}

// src/edu/ccrm/util/exceptions/FileImportException.java
package edu.ccrm.util.exceptions;

public class FileImportException extends Exception {
    public FileImportException(String message) {
        super(message);
    }
    
    public FileImportException(String message, Throwable cause) {
        super(message, cause);
    }
}