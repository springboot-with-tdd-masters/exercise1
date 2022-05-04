package com.example.exercise1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<String> handleAllException(Exception e, WebRequest req) {
		return new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	public final ResponseEntity<String> handleRecordNotFoundException(Exception e, WebRequest req) {
		return new ResponseEntity<String>("Book Not Found", HttpStatus.NOT_FOUND);
	}
}
