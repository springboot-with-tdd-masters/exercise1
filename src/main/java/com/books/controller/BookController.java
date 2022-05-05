package com.books.controller;

import com.books.errorhandler.BookNotFoundException;
import com.books.model.Book;
import com.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) throws BookNotFoundException {

        return new ResponseEntity<Book>(bookService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.delete(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Book> put(@PathVariable Integer id, @RequestBody Book book) throws
            BookNotFoundException{
        return new ResponseEntity<>(bookService.update(id, book), HttpStatus.OK);
    }
}
