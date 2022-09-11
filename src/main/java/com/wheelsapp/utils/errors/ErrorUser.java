package com.wheelsapp.utils.errors;

/**
 * @author Laura Garcia
 */
public enum ErrorUser {
    MAX_LENGTH_NAME ("the name should be less than 40 characters"),
    MAX_LENGTH_LASTNAME("The last name should be less than 60 characters"),
    MAX_LENGTH_EMAIL("The email should be less than 120 characters"),
    DUPLICATED_EMAIL("Email in use");

    private String label;

    private ErrorUser(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
