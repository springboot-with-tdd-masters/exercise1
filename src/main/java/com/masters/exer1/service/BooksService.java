package com.masters.exer1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.masters.exer1.model.Book;
import com.masters.exer1.repository.BooksRepository;
import exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//defining the business logic
@Service
public class BooksService
{
    @Autowired
    BooksRepository booksRepository;

    public List<Book> getAllBooks()
    {
        List<Book> books = new ArrayList<Book>();
        booksRepository.findAll().forEach(item -> books.add(item));
        return books;
    }

    public Book getBooksById(int id) throws RecordNotFoundException
    {
        Optional<Book> book = booksRepository.findById(id);
        if(book.isPresent()) {
            return book.get();
        } else {
            throw new RecordNotFoundException("No book record exists with the provided ID.");
        }
    }

    public Book saveOrUpdate(Book book)
    {
        Optional<Book> item = booksRepository.findById(book.getId());

        if(item.isPresent()){
            Book newItem = item.get();
            newItem.setAuthor(book.getAuthor());
            newItem.setTitle(book.getTitle());
            newItem = booksRepository.save(newItem);
            return newItem;
        } else {
            return booksRepository.save(book);
        }
    }

    public Book delete(int id) throws RecordNotFoundException
    {
        Optional<Book> book = booksRepository.findById(id);
        if(book.isPresent()) {
            booksRepository.deleteById(id);
            return book.get();
        } else {
            throw new RecordNotFoundException("No book record exists with the provided ID.");
        }
    }

    public void update(Book book, int id)
    {
        booksRepository.save(book);
    }
}