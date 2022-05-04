package com.example.demosessiontwo.service;

import com.example.demosessiontwo.exception.RecordNotFoundException;
import com.example.demosessiontwo.model.Book;
import com.example.demosessiontwo.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;

  public Book getById(Integer id) throws RecordNotFoundException {
    Optional<Book> bookFromDB = bookRepository.findById(id);
    if (bookFromDB.isPresent()) {
      return bookFromDB.get();
    } else {
      throw new RecordNotFoundException("Cannot find Book with id :" + id.toString());
    }
  }

  public List<Book> getAll() {
    return bookRepository.findAll();
  }

  public void update(Book book) throws RecordNotFoundException {
    Optional<Book> bookFromDB = bookRepository.findById(book.getId());
    if (bookFromDB.isPresent()) {
      Book newBookEntity = bookFromDB.get();
      newBookEntity.setAuthor(book.getAuthor());
      newBookEntity.setTitle(book.getTitle());
      bookRepository.save(newBookEntity);
    } else {
      throw new RecordNotFoundException("Cannot update Book with id :" + book.getId());
    }
  }

  public void create(Book book){
    bookRepository.save(book);
  }

  public void delete(Integer id) throws RecordNotFoundException {
    Optional<Book> bookFromDB = bookRepository.findById(id);
    if (bookFromDB.isPresent()) {
      bookRepository.delete(bookFromDB.get());
    } else {
      throw new RecordNotFoundException("Cannot delete Book with id :" + id);
    }
  }
}
