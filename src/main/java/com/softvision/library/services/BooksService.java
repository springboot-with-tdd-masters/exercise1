package com.softvision.library.services;

import com.softvision.library.models.Book;

import java.util.List;

public interface BooksService {
	public List<Book> getAll();
	public Book getById(long id);
	public Book createOrUpdate(Book entity);
	public void deleteById(long id);
}
