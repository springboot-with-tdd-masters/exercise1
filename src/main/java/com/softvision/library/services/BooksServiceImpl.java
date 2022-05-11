package com.softvision.library.services;

import com.softvision.library.models.Book;
import com.softvision.library.models.RecordNotFoundException;
import com.softvision.library.repositories.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	BooksRepository repository;
	
	public List<Book> getAll() {
		return repository.findAll();	
	}
	
	public Book getById(long id) {
		return repository.findById(id).orElseThrow(RecordNotFoundException::new);
	}
	
	public Book createOrUpdate(final Book entity) {
		return repository.findById(entity.getId()).map(entityToBeUpdated -> {
			entityToBeUpdated.setAuthor(entity.getAuthor());
			entityToBeUpdated.setTitle(entity.getTitle());

			entityToBeUpdated = repository.save(entityToBeUpdated);
			return entityToBeUpdated;
		}).orElse(repository.save(entity));
	}
	
	public void deleteById(long id) {
		repository.findById(id).orElseThrow(RecordNotFoundException::new);		
		repository.deleteById(id); 	
	}
}
