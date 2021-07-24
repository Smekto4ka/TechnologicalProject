package ru.oogis.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@Log4j2
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControllerValidateExceptionHandler {
    //TODO catches @Validated errors
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> validationError(ConstraintViolationException ex) {
        ValidationErrorResponse validationError = new ValidationErrorResponse();
        for (ConstraintViolation violation : ex.getConstraintViolations()) {
            validationError.addViolation(
                    new Violation(violation.getPropertyPath().toString(),
                            violation.getMessage()));
        }
        log.error(validationError.toString());
        return new ResponseEntity<>(validationError, HttpStatus.CONFLICT);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ValidationErrorResponse validError = new ValidationErrorResponse();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            validError.getViolations().add(
                    new Violation(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        log.error(validError.toString());
        return new ResponseEntity<>(validError, HttpStatus.CONFLICT);
    }
}
