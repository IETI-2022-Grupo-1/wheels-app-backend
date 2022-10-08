package com.wheelsapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.wheelsapp.exception.customExceptions.InvalidObjectException;
import com.wheelsapp.exception.customExceptions.ObjectNotFoundException;
import com.wheelsapp.exception.customExceptions.DuplicateEntityException;
import com.wheelsapp.exception.customExceptions.InvalidCredentialsException;

@RestController
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(DuplicateEntityException.class)
    public ResponseEntity<ExceptionResponse> handleDuplicateEntityException(DuplicateEntityException exception,
                                                                            WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotObjectFound(ObjectNotFoundException exception,
                                                                          WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidObjectException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidObjectException(InvalidObjectException exception,
                                                                          WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ExceptionResponse> handleUnauthorizedException(InvalidCredentialsException exception,
                                                                         WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}