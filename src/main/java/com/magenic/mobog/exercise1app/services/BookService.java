package com.magenic.mobog.exercise1app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.magenic.mobog.exercise1app.exceptions.BookNotFoundException;
import com.magenic.mobog.exercise1app.model.Book;
import com.magenic.mobog.exercise1app.repositories.BookRepository;
import com.magenic.mobog.exercise1app.requests.AddBookRequest;
import com.magenic.mobog.exercise1app.requests.UpdateBookRequest;
import com.magenic.mobog.exercise1app.responses.BookResponse;

@Service
public class BookService {
	private BookRepository repository;
	
	public BookService(BookRepository repository) {
		this.repository = repository;
	}
	
	
	public BookResponse getById(Long id) throws BookNotFoundException {
		return Optional.ofNullable(this.repository.findById(id))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(this::mapToBookResponse)
				.orElseThrow(BookNotFoundException::new);
	}
	public List<BookResponse> findAll(){
		return this.repository.findAll()
				.stream()
				.map(this::mapToBookResponse)
				.toList();
	}
	public BookResponse deleteById(Long id) throws BookNotFoundException {
		Optional<Book> retrieved = this.repository.findById(id);
		if(retrieved.isPresent()) {
			Book book = retrieved.get();
			this.repository.delete(book);
			return this.mapToBookResponse(book);
		} else {
			throw new BookNotFoundException();
		}
	}
	public BookResponse updateBookDetails(UpdateBookRequest book) throws BookNotFoundException {
		return Optional.ofNullable(this.repository.findById(book.getId()))
				.filter(Optional::isPresent)
				.map(Optional::get)
				.map(old -> this.mapToBook(old, book))
				.map(this.repository::save)
				.map(this::mapToBookResponse)
				.orElseThrow(BookNotFoundException::new);
		
	}
	public BookResponse addBook(AddBookRequest book) throws BookNotFoundException {
		return Optional.ofNullable(book)
				.map(this::mapToBook)
				.map(this.repository::save)
				.map(this::mapToBookResponse)
				.orElseThrow(BookNotFoundException::new);
	}
	
	private Book mapToBook(Book old, UpdateBookRequest req) {
		old.setAuthor(req.getAuthor());
		old.setTitle(req.getTitle());
		return old;
	}
	private Book mapToBook(AddBookRequest req) {
		Book book = new Book();
		book.setAuthor(req.getAuthor());
		book.setTitle(req.getTitle());
		return book;
	}
	private BookResponse mapToBookResponse(Book book) {
		BookResponse res = new BookResponse();
		res.setAuthor(book.getAuthor());
		res.setTitle(book.getTitle());
		res.setId(book.getId());
		return res;
	}
}
