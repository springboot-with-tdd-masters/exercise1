package com.java.master.exercise1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.master.exercise1.exception.RecordNotFoundException;
import com.java.master.exercise1.model.Book;
import com.java.master.exercise1.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping(value = "/create")
	public Book createUpdateBook(@RequestBody Book book) throws RecordNotFoundException {
		return bookService.createUpdateBook(book);
	}

	@GetMapping(value = "/getAll")
	public List<Book> getAllBooks() throws RecordNotFoundException {
		return bookService.getAllBooks();
	}

	@DeleteMapping(value = "/delete/{id}")
	public Book deleteBookById(@PathVariable Long id) throws RecordNotFoundException {
		return bookService.deleteBookById(id);
	}

	@GetMapping(value = "/getById/{id}")
	public Book getBookById(@PathVariable Long id) throws RecordNotFoundException {
		return bookService.getBookById(id);
	}
}
