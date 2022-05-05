package com.java.master.exercise1.service;

import java.util.List;

import com.java.master.exercise1.model.Book;

public interface BookService {
	
	Book createUpdateBook(Book book);

	List<Book> getAllBooks();

	Book deleteBookById(Long id);

	Book getBookById(Long id);
}
