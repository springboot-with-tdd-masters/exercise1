package com.example.exercise1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercise1.model.Book;
import com.example.exercise1.service.BookService;

@RestController
@RequestMapping("/books") 
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBook(@PathVariable long id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping("/add")
	public Book addBooks(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PostMapping("/update")
	public Book updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
	}
}
