package com.example.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.exception.RecordNotFoundException;
import com.example.book.model.Book;
import com.example.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;

	public List<Book> getAllBooks() {

		List<Book> bookList = bookRepository.findAll();
		if (bookList.size() > 0) {
			return bookList;
		} else {
			return new ArrayList<Book>();
		}
	}

	public Book getBookById(Long id) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(id);

		if (book.isPresent()) {
			return book.get();
		} else {
			throw new RecordNotFoundException("No book record exist for given id");
		}
	}

	public Book createOrUpdateBook(Book entity) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(entity.getId());

		if (book.isPresent()) {
			Book newEntity = book.get();
			newEntity.setAuthor(entity.getAuthor());
			newEntity.setTitle(entity.getTitle());

			newEntity = bookRepository.save(newEntity);

			return newEntity;
		} else {
			entity = bookRepository.save(entity);

			return entity;
		}
	}

	public void deleteByUserId(Long id) throws RecordNotFoundException {
		Optional<Book> book = bookRepository.findById(id);

		if (book.isPresent()) {
			bookRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No book record exist for given id");
		}
	}

}
