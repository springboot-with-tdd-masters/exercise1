package com.csv.bookscrudexercise1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csv.bookscrudexercise1.exception.RecordNotFoundException;
import com.csv.bookscrudexercise1.model.Book;
import com.csv.bookscrudexercise1.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;
	
	public List<Book> getAllBooks() {
		List<Book> bookList = repository.findAll();
		
		if(bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<Book>();
		}
	}
	
	public Book getBookById(Long id) throws RecordNotFoundException {
		Optional<Book> book = repository.findById(id);
		
		if(book.isPresent()) {
			return book.get();
		} else {
			throw new RecordNotFoundException("Book does not exist");
		}
	}
	
	public Book createOrUpdateBook(Book bookEntity) throws RecordNotFoundException {
		Optional<Book> book = repository.findById(bookEntity.getId());
		
		if(book.isPresent()) {
			
			Book newBook = book.get();
			newBook.setTitle(bookEntity.getTitle());
			newBook.setAuthor(bookEntity.getAuthor());
			
			newBook = repository.save(bookEntity);
			return newBook;
			
		} else {
			bookEntity = repository.save(bookEntity);
			return bookEntity;
		}
	}
	
	public Book deleteBook(Long id) throws RecordNotFoundException {
		Optional<Book> book = repository.findById(id);
		if(book.isPresent()) {
			repository.deleteById(id);
			return book.get();
		} else {
			throw new RecordNotFoundException("Book does not exist");
		}
		
	}
}
