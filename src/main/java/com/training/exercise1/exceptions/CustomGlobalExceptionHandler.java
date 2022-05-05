/**
 * 
 */
package com.training.exercise1.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author michaeldelacruz
 *
 */

@ControllerAdvice
public class CustomGlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
		return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleBookNotFoundException(RecordNotFoundException exception, WebRequest request) {
		return new ResponseEntity<Object>(exception.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
		
	}
}
