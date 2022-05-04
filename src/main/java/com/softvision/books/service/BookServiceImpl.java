package com.softvision.books.service;

import com.softvision.books.controller.beans.BookForm;
import com.softvision.books.domain.Book;
import com.softvision.books.exceptions.NotFoundException;
import com.softvision.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException());
    }

    @Override
    public Book create(BookForm bookForm) {
        return bookRepository.save(
                new Book(bookForm.getTitle(), bookForm.getAuthor())
        );
    }

    @Override
    public Book update(Long id, BookForm bookForm) {

        final Book bookToUpdate = findById(id);

        bookToUpdate.setTitle(bookForm.getTitle());
        bookToUpdate.setAuthor(bookForm.getAuthor());

        return bookRepository.save(bookToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
