package com.HalaSuliman.Bloomberg.FXDeals.Services;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.time.LocalDateTime;
@ControllerAdvice
public class ValidationExceptionHandlerService {
    private static final Logger logger = LoggerFactory.getLogger(ValidationExceptionHandlerService.class);

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> notValid(MethodArgumentTypeMismatchException ex, HttpServletRequest request) {
        ErrorRes errorResponse=new ErrorRes("Wrong values", ex.getMessage(), LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());
        logger.error(errorResponse.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    /*To handle duplicates Rows Error*/
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<?> constraintViolation(ConstraintViolationException ex, HttpServletRequest request) {
        ErrorRes errorResponse=new ErrorRes("Duplicate vlaue", ex.getMessage(), LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());
        logger.error("Can't be saved to db because {}",errorResponse.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    /*To handle deserialization Error*/
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> notReadable(HttpMessageNotReadableException ex, HttpServletRequest request) {
        ErrorRes errorResponse= new ErrorRes("Wrong value",ex.getMessage(), LocalDateTime.now(),HttpStatus.BAD_REQUEST.value());
        logger.error("Can't deserialize the body because {}", errorResponse.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
