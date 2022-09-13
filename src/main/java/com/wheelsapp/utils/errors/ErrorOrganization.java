package com.wheelsapp.utils.errors;

public enum ErrorOrganization {

    MAX_LENGTH_NAME ("the name should be less than 150 characters"),
    MAX_LENGTH_NIT("The last name should be less than 40 characters"),
    MAX_LENGTH_EMAIL("The email can only be seen by an Admin"),
    DUPLICATED_NIT("NIT  in use");
    private String label;

    private ErrorOrganization(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
