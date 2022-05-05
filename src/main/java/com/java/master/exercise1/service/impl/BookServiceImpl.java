package com.java.master.exercise1.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.master.exercise1.exception.RecordNotFoundException;
import com.java.master.exercise1.model.Book;
import com.java.master.exercise1.repository.BookRepository;
import com.java.master.exercise1.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book deleteBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			bookRepository.deleteById(id);
			return book.get();
		} else {
			throw new RecordNotFoundException("Book not found!");
		}
	}

	@Override
	public Book getBookById(Long id) {
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new RecordNotFoundException("Book not found!");
		}
	}

	@Override
	public Book createUpdateBook(Book bookRequest) {
		Optional<Book> book = bookRepository.findById(bookRequest.getId());
		if (book.isPresent()) {
			Book updateBook = book.get();
			updateBook.setTitle(bookRequest.getTitle());
			updateBook.setAuthor(bookRequest.getAuthor());
			bookRepository.save(bookRequest);
			return updateBook;
		} else {
			bookRepository.save(bookRequest);
			return bookRequest;
		}
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books.size() > 0 ? books : new ArrayList<>();
	}

}
