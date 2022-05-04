package com.softvision.books.service;

import com.softvision.books.controller.beans.BookForm;
import com.softvision.books.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Long id);

    Book create(BookForm bookForm);

    Book update(Long id, BookForm bookForm);

    void deleteById(Long id);

}
