package com.books.repository;

import com.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {
}
