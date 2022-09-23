package com.wheelsapp.exception;

import com.wheelsapp.exception.customExceptions.DuplicateEntityException;
import com.wheelsapp.exception.customExceptions.InvalidObjectException;
import org.springframework.stereotype.Component;

@Component
public class ExceptionGenerator {

    public static RuntimeException getException(ExceptionType type, String message) {
        switch (type) {
            case DUPLICATE_ENTITY:
                return new DuplicateEntityException(message);
            case INVALID_OBJECT:
                return new InvalidObjectException(message);
            default:
                return new RuntimeException(message);
        }
    }
}
