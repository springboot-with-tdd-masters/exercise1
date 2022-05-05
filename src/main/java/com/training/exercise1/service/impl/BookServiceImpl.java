/**
 * 
 */
package com.training.exercise1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.exercise1.exceptions.RecordNotFoundException;
import com.training.exercise1.model.Book;
import com.training.exercise1.repository.BookRepository;
import com.training.exercise1.service.BookService;

/**
 * @author michaeldelacruz
 *
 */

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findAll() throws RecordNotFoundException {
		List<Book> books = bookRepository.findAll();
		if(books.size() <= 0) {
			throw new RecordNotFoundException("No record found");
		}
		return books;
	}

	@Override
	public Book findById(Long id) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(id);
		if(!book.isPresent()) {
			throw new RecordNotFoundException("Record with id:" + id + " not found ");
		}
		return book.get();
	}

	@Override
	public Book saveOrUpdate(Book book) {
		if(book.getId() != null) {
			Optional<Book> bookObj = bookRepository.findById(book.getId());
			if(bookObj.isPresent()) {
				Book bookEntity = bookObj.get();
				bookEntity.setTitle(book.getTitle());
				bookEntity.setAuthor(book.getAuthor());
				return bookRepository.save(bookEntity);
			} 
		}
		return bookRepository.save(book);

	}

	@Override
	public Book delete(Long id) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(id);
		if(!book.isPresent()) {
			throw new RecordNotFoundException("Record with id:" + id + " not found ");
		}
		bookRepository.deleteById(id);
		return book.get();
	}

}
