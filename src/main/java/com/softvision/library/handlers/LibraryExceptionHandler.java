package com.softvision.library.handlers;

import com.softvision.library.models.LibraryError;
import com.softvision.library.models.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.UrlPathHelper;

import java.util.Date;

@ControllerAdvice
public class LibraryExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    UrlPathHelper urlPathHelper;

    @ExceptionHandler
    public final ResponseEntity<LibraryError> handleGenericException(Exception ex,
                                                                     WebRequest request) {
        return new ResponseEntity<>(new LibraryError("Internal Server Error. " + ex.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    new Date(),
                    urlPathHelper.getPathWithinApplication(((ServletWebRequest)request).getRequest())),
                new HttpHeaders(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public final ResponseEntity<LibraryError> handleRecordNotFoundException(RecordNotFoundException ex,
                                                                            WebRequest request) {
        return new ResponseEntity<>(new LibraryError("Record Not Found.",
                    HttpStatus.NOT_FOUND.value(),
                    new Date(),
                    urlPathHelper.getPathWithinApplication(((ServletWebRequest)request).getRequest())),
                new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                    HttpHeaders headers,
                                                                    HttpStatus status,
                                                                    WebRequest request) {
        return new ResponseEntity<>(new LibraryError("Validation failed. " + ex.getMessage(),
                    HttpStatus.BAD_REQUEST.value(),
                    new Date(),
                    urlPathHelper.getPathWithinApplication(((ServletWebRequest)request).getRequest())),
                headers,
                HttpStatus.BAD_REQUEST);
    }
}
