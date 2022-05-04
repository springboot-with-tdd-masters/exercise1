package com.masters.masters.exercise.services;

import com.masters.masters.exercise.exception.RecordNotFoundException;
import com.masters.masters.exercise.model.Book;
import com.masters.masters.exercise.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired private BookRepo bookRepo;

    public Book saveOrUpdateBook(Book book){
        return bookRepo.save(book);
    }

    public Book getBookById(Long id) throws RecordNotFoundException {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty()){
         throw new RecordNotFoundException("Book does not exist");
        }
        return bookRepo.getById(id);
    }

    public List<Book> findAll(){
        List<Book> books = bookRepo.findAll();
        if(!books.isEmpty()){
            return  books;
        }else {
            return new ArrayList<>();
        }
    }

    public void deleteById(Long id) throws RecordNotFoundException {
        Optional<Book> book = bookRepo.findById(id);
        if(book.isEmpty()){
            throw new RecordNotFoundException("Book does not exist");
        }
        bookRepo.deleteById(id);
    }
}
