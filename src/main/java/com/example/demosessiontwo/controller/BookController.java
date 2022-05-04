package com.example.demosessiontwo.controller;

import com.example.demosessiontwo.exception.RecordNotFoundException;
import com.example.demosessiontwo.model.Book;
import com.example.demosessiontwo.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

  @Autowired
  BookService bookService;

  @GetMapping("/{id}")
  public Book getOne(@PathVariable Integer id) throws RecordNotFoundException {
    return bookService.getById(id);
  }

  @GetMapping()
  public List<Book> getAll(){
    return bookService.getAll();
  }

  @PostMapping()
  public void create(@RequestBody Book book) {
    bookService.create(book);
  }

  @PutMapping()
  public void update(@RequestBody Book book) throws RecordNotFoundException {
    bookService.update(book);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) throws RecordNotFoundException {
    bookService.delete(id);
  }
}
