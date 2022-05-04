package com.example.demosessiontwo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllException(Exception e, WebRequest req) {
    return new ResponseEntity<Object>("Internal Server Error", new HttpHeaders(),
        HttpStatus.INTERNAL_SERVER_ERROR);

  }

  @ExceptionHandler(RecordNotFoundException.class)
  public final ResponseEntity<Object> handleRecordNotFoundException(Exception e, WebRequest req) {
    return new ResponseEntity<Object>("Record Not Found", new HttpHeaders(), HttpStatus.NOT_FOUND);

  }

}
