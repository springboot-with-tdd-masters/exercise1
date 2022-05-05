package com.books.service;

import com.books.errorhandler.BookNotFoundException;
import com.books.model.Book;

public interface BookService {

    public Book save(Book book);

    public Book update(Integer id, Book book)  throws BookNotFoundException;

    public Book delete(Integer id)  throws BookNotFoundException;

    public Book findById(Integer id)  throws BookNotFoundException;
}
