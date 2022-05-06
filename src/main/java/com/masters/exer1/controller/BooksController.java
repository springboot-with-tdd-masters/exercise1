package com.masters.exer1.controller;

import com.masters.exer1.model.Book;
import com.masters.exer1.service.BooksService;
import exception.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksController
{

    @Autowired
    BooksService booksService;

    @GetMapping()
    private ResponseEntity<List<Book>> getAllBooks()
    {
        List<Book> bookList = booksService.getAllBooks();
        return new ResponseEntity<List<Book>>(bookList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Book> getBooks(@PathVariable("id") int id) throws RecordNotFoundException
    {
        Book book = booksService.getBooksById(id);
        return new ResponseEntity<Book>(book, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteBook(@PathVariable("id") int id) throws RecordNotFoundException
    {
        booksService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    private ResponseEntity<Book> saveBook(@RequestBody Book book)
    {
        Book item = booksService.saveOrUpdate(book);
        return new ResponseEntity<Book>(item, new HttpHeaders(), HttpStatus.OK);
    }

}
