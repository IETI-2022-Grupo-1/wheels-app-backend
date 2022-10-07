package com.wheelsapp.utils.errors;

public enum ErrorRide {
    DELETE_RIDE ("The user was impossible to delete");
    private String label;

    private ErrorRide(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
