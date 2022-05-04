package com.example.exerciseone.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exerciseone.exception.RecordNotFoundException;
import com.example.exerciseone.model.Book;
import com.example.exerciseone.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public List<Book> getAllBooks(){
		List<Book> books = repository.findAll();
		
		if (books.size() > 0) {
			return books;
		} else {
			return new ArrayList<Book>();
		}
		
	}
	
	public Book getBookById(Long id) throws RecordNotFoundException{
		Optional<Book> book = repository.findById(id);
		
		if (book.isPresent()) {
			return book.get();
		} else {
			throw new RecordNotFoundException("There is no book with that ID");
		}
	}
	
	public Book createOrUpdateBook(Book bookEntity) throws RecordNotFoundException{
		Optional<Book> book = repository.findById(bookEntity.getId());
		
		if (book.isPresent()) {
			Book newBook = book.get();
			newBook.setTitle(bookEntity.getTitle());
			newBook.setAuthor(bookEntity.getAuthor());
			
			return repository.save(newBook);
		} else {
			return repository.save(bookEntity);
		}
	}
	
	public Book deleteByBookId(Long id) throws RecordNotFoundException {
		Optional<Book> book = repository.findById(id);
		
		if (book.isPresent()) {
			repository.deleteById(id);
			return book.get();
		} else {
			throw new RecordNotFoundException("There is no book with that ID");
		}
	}
}
