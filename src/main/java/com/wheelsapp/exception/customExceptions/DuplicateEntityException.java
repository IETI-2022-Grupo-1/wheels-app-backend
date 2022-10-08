package com.wheelsapp.exception.customExceptions;

/**
 * @author Laura Garcia
 */
public class DuplicateEntityException extends RuntimeException {

    public DuplicateEntityException(String message) {
        super(message);
    }

}
