package com.wheelsapp.exception;

import org.springframework.stereotype.Component;
import com.wheelsapp.exception.customExceptions.InvalidObjectException;
import com.wheelsapp.exception.customExceptions.ObjectNotFoundException;
import com.wheelsapp.exception.customExceptions.DuplicateEntityException;
import com.wheelsapp.exception.customExceptions.InvalidCredentialsException;

@Component
public class ExceptionGenerator {
    public static RuntimeException getException(ExceptionType type, String message) {
        switch (type) {
            case DUPLICATE_ENTITY:
                return new DuplicateEntityException(message);
            case INVALID_OBJECT:
                return new InvalidObjectException(message);
            case NOT_FOUND:
                return new ObjectNotFoundException(message);
            case INVALID_CREDENTIALS:
                return new InvalidCredentialsException(message);
            default:
                return new RuntimeException(message);
        }
    }
}