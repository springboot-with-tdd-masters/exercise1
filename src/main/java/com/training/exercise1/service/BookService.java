/**
 * 
 */
package com.training.exercise1.service;

import java.util.List;

import com.training.exercise1.exceptions.RecordNotFoundException;
import com.training.exercise1.model.Book;

/**
 * @author michaeldelacruz
 *
 */
public interface BookService {

	public List<Book> findAll() throws RecordNotFoundException;
	
	public Book findById(Long id) throws RecordNotFoundException;
	
	public Book saveOrUpdate(Book book);
	
	public Book delete(Long id) throws RecordNotFoundException;
	
}
