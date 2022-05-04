package com.softvision.books.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final String MESSAGE = "Book not found.";

    public NotFoundException() {
        super(MESSAGE);
    }
}
