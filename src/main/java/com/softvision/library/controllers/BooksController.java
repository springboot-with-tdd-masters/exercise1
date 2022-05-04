package com.softvision.library.controllers;

import com.softvision.library.models.Book;
import com.softvision.library.services.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksService booksService;
	
	@GetMapping
	public List<Book> getAll() {
		return booksService.getAll();
	}
	
	@GetMapping("/{id}")
	public Book getById(@PathVariable("id") long id) {
		return booksService.getById(id);
	}
	
	@PostMapping
	public ResponseEntity<Book> createOrUpdateUser(@RequestBody Book book) {
		Book updated = booksService.createOrUpdate(book);
		return new ResponseEntity<Book>(updated, new HttpHeaders(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable("id") long id) {
		booksService.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
