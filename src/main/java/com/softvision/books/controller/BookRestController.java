package com.softvision.books.controller;

import com.softvision.books.controller.beans.BookForm;
import com.softvision.books.domain.Book;
import com.softvision.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rest/books")
public class BookRestController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @GetMapping("{id:\\d+}")
    public Book get(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book create(@RequestBody BookForm bookForm) {
        return bookService.create(bookForm);
    }

    @PutMapping("{id:\\d+}")
    public Book update(@PathVariable Long id, @RequestBody BookForm bookForm) {
        return bookService.update(id, bookForm);
    }

    @DeleteMapping("{id:\\d+}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }

}
