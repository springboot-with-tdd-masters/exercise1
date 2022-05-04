package com.example.exercise1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exercise1.exception.BookNotFoundException;
import com.example.exercise1.model.Book;
import com.example.exercise1.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(BookNotFoundException::new);
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		Book toUpdate = getBookById(book.getId());
		toUpdate.setTitle(book.getTitle());
		toUpdate.setAuthor(book.getAuthor());
		return bookRepository.save(toUpdate);
	}
	
	public void deleteBook(Long id) {
		Book toDelete = getBookById(id);
		bookRepository.delete(toDelete);
	}
}
