package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> get() {
        List<Book> retrievedBooks = bookRepository.findAll();
        return new ResponseEntity<List<Book>>(retrievedBooks, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> retrievedBook = bookRepository.findById(id);
        if(retrievedBook.isPresent()){
            return new ResponseEntity<Book>(retrievedBook.get(), new HttpHeaders(), HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBookById(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book newBook = Book.builder().author(book.getAuthor()).title(book.getTitle()).build();
        Book addedBook = saveBook(newBook);
        return new ResponseEntity<Book>(addedBook, new HttpHeaders(), HttpStatus.OK);
    }

    private Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/updateBook")
    private void put(@RequestBody Book book) {
        Optional<Book> retrievedBook = bookRepository.findById(Long.valueOf(book.getId()));
        if (retrievedBook.isPresent()) {
            Book bookToBeUpdated = retrievedBook.get();
            bookToBeUpdated.setAuthor(book.getAuthor());
            bookToBeUpdated.setTitle(book.getTitle());
            saveBook(bookToBeUpdated);
        }
    }
}
