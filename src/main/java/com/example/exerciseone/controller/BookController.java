package com.example.exerciseone.controller;

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

import com.example.exerciseone.exception.RecordNotFoundException;
import com.example.exerciseone.model.Book;
import com.example.exerciseone.service.BookService;

@Controller
@RequestMapping(value = "/books")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping()
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = service.getAllBooks();
		
		return new ResponseEntity<List<Book>>(books, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) throws RecordNotFoundException {
		Book book = service.getBookById(id);
		
		return new ResponseEntity<Book>(book, new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Book> createOrUpdateBook(@RequestBody Book book) throws RecordNotFoundException {
		Book newBook = service.createOrUpdateBook(book);
		
		return new ResponseEntity<Book>(newBook, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable("id") Long id) throws RecordNotFoundException {
		service.deleteByBookId(id);
		
		return ResponseEntity.noContent().build();
	}

}
