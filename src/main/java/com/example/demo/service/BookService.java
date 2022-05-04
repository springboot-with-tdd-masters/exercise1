package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    //create book
    public Book addBook(Book book){
         return bookRepo.save(book);

    }

    //get a book
    public Optional<Book> getBook(Long id){
        return bookRepo.findById(id);
    }

    //get all books
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    //delete a book
    public void deleteBook(Long id){
         bookRepo.deleteById(id);
    }

}
