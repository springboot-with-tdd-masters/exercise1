package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.exception.RecordNotFoundException;
import com.example.book.model.Book;
import com.example.book.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list = bookService.getAllBooks();
		
		return new ResponseEntity<List<Book>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Book entity = bookService.getBookById(id);
		
		return new ResponseEntity<Book>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> createOrUpdateBook(@RequestBody Book books) throws RecordNotFoundException {
		Book updated = bookService.createOrUpdateBook(books);
		
		return new ResponseEntity<Book>(updated, new HttpHeaders(), HttpStatus.OK);
	} 
	
	@DeleteMapping("/{id}")
	public HttpStatus deleteUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
		bookService.deleteByUserId(id);
		
		return HttpStatus.FORBIDDEN;
	}

}
