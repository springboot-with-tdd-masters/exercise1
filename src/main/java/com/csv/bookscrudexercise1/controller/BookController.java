package com.csv.bookscrudexercise1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csv.bookscrudexercise1.exception.RecordNotFoundException;
import com.csv.bookscrudexercise1.model.Book;
import com.csv.bookscrudexercise1.service.BookService;

@RestController
@RequestMapping(value="/books")
public class BookController {

	@Autowired
	BookService service;
	
	@GetMapping()
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable Long id) throws RecordNotFoundException {
		return service.getBookById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteBookById(@PathVariable Long id) throws RecordNotFoundException {
		service.deleteBook(id);
	}
	
	@PostMapping
	public Book createOrUpdateBook(@RequestBody Book book) throws RecordNotFoundException {
		return service.createOrUpdateBook(book);
	}
	
}
