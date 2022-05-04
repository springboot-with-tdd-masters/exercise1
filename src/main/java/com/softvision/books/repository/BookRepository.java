package com.softvision.books.repository;

import com.softvision.books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllBy();

    Optional<Book> findBookById(Long id);

}
