/**
 * 
 */
package com.training.exercise1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.exercise1.exceptions.RecordNotFoundException;
import com.training.exercise1.model.Book;
import com.training.exercise1.service.BookService;

/**
 * @author michaeldelacruz
 *
 */

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> retrieveAllBooks() throws RecordNotFoundException {
		List<Book> books = bookService.findAll();
		return books;	
	}
	
	@GetMapping("/{id}")
	public Book retrieveBookById(@PathVariable Long id) throws RecordNotFoundException {
		Book book = bookService.findById(id);
		return book;
	}
	
	@PostMapping
	public Book saveBook(@RequestBody Book book) {
		Book bookObj = bookService.saveOrUpdate(book);
		return bookObj;
	}
	
	@DeleteMapping("/{id}")
	public Book deleteBookById(@PathVariable Long id) throws RecordNotFoundException {
		Book bookObj = bookService.delete(id);
		return bookObj;
	}
	
}
