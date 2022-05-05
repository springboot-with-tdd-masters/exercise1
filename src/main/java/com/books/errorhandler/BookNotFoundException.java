package com.books.errorhandler;

public class BookNotFoundException extends Exception {

    public BookNotFoundException() {
        super("Book Not Found Exception.");
    }
}
