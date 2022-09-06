package com.trackline.tracking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResouceNotFoundExceptionHandler(ResourceNotFoundException ex){
       ErrorMessage error= new ErrorMessage();
        error.setMessage(ex.getMessage());
        error.setTimeStamp(OffsetDateTime.now());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
       return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorMessage> conflictExceptionHandler(ConflictException ex){
        ErrorMessage error= new ErrorMessage();
        error.setMessage(ex.getMessage());
        error.setTimeStamp(OffsetDateTime.now());
        error.setStatusCode(HttpStatus.CONFLICT.value());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.OK);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorMessage> noHandlerFoundExceptionHandler(NoHandlerFoundException ex){
        ErrorMessage error= new ErrorMessage();
        error.setMessage(ex.getMessage());
        error.setTimeStamp(OffsetDateTime.now());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorMessage> methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex){
        ErrorMessage error= new ErrorMessage();
        error.setMessage(ex.getMessage());
        error.setTimeStamp(OffsetDateTime.now());
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<ErrorMessage>(error, HttpStatus.BAD_REQUEST);
    }


    /*@ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> errorException(Exception ex){
        ErrorMessage error=  new ErrorMessage();
        error.setMessage(ex.getMessage());
        error.setTimeStamp(OffsetDateTime.now());
        error.setStatusCode(0);
        return new ResponseEntity<ErrorMessage>(error,HttpStatus.NOT_FOUND);
    }*/

}
