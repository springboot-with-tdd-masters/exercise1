package com.java.master.exercise1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler({ RecordNotFoundException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> handleErrorNotFound(final Throwable e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
