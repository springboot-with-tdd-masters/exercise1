package com.magenic.mobog.exercise1app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magenic.mobog.exercise1app.exceptions.BookNotFoundException;
import com.magenic.mobog.exercise1app.requests.AddBookRequest;
import com.magenic.mobog.exercise1app.requests.UpdateBookRequest;
import com.magenic.mobog.exercise1app.responses.BookResponse;
import com.magenic.mobog.exercise1app.services.BookService;

@RestController
public class BookController {
	private BookService service;
	
	public BookController(BookService service) {
		this.service = service;
	}
	
	@GetMapping("/{id}")
	public BookResponse getById(@PathVariable Long id) throws BookNotFoundException {
		return service.getById(id);
	}
	@GetMapping
	public List<BookResponse> findAll() throws BookNotFoundException {
		return service.findAll();
	}
	@PutMapping
	public BookResponse updateBook(@RequestBody UpdateBookRequest request) throws BookNotFoundException {
		return service.updateBookDetails(request);
	}
	@PostMapping
	public BookResponse addBook(@RequestBody AddBookRequest request) throws BookNotFoundException {
		return service.addBook(request);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) throws BookNotFoundException {
		BookResponse deleted = service.deleteById(id);
		return Optional.ofNullable(deleted)
				.map(d -> ResponseEntity.noContent().<Void>build())
				.orElseThrow(BookNotFoundException::new);
	}

}
