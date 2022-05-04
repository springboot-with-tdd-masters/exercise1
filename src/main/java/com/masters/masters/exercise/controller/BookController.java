package com.masters.masters.exercise.controller;

import com.masters.masters.exercise.exception.RecordNotFoundException;
import com.masters.masters.exercise.model.Book;
import com.masters.masters.exercise.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired private BookService bookService;

    @PostMapping
    public Book saveOrUpdateBook(@RequestBody Book book){
        return bookService.saveOrUpdateBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) throws RecordNotFoundException {
        bookService.deleteById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) throws RecordNotFoundException {
        return bookService.getBookById(id);
    }
}
