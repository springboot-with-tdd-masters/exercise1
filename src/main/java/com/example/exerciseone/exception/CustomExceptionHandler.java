package com.example.exerciseone.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity<Object>("Internal Server Error", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleBookNotFoundException(RecordNotFoundException ex, WebRequest request) {
		return new ResponseEntity<Object>("There is no book with that ID", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}

}
