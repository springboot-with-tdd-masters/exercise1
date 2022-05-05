package com.books.service;

import com.books.errorhandler.BookNotFoundException;
import com.books.model.Book;
import com.books.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public Book save(Book book) {
        booksRepository.save(book);

        return book;
    }

    @Override
    public Book update(Integer id, Book book) throws BookNotFoundException {

        Optional<Book> optionalCurrentBook = booksRepository.findById(id);

        if (optionalCurrentBook.isEmpty()) {
            throw new BookNotFoundException();
        }

        Book currentBook = optionalCurrentBook.get();
        currentBook.setTitle(book.getTitle());
        currentBook.setDescription(book.getDescription());
        currentBook.setDatePublished(book.getDatePublished());

        booksRepository.save(currentBook);

        return currentBook;
    }

    @Override
    @Transactional
    public Book delete(Integer id) throws BookNotFoundException{

        Optional<Book> optionalCurrentBook = booksRepository.findById(id);

        if (optionalCurrentBook.isEmpty()) {
            throw new BookNotFoundException();
        }

        Book currentBook = optionalCurrentBook.get();
        booksRepository.deleteById(id);

        return currentBook;
    }

    @Override
    public Book findById(Integer id) throws BookNotFoundException {
        Optional<Book> optionalCurrentBook = booksRepository.findById(id);

        if (optionalCurrentBook.isEmpty()) {
            throw new BookNotFoundException();
        }

        return optionalCurrentBook.get();
    }
}
