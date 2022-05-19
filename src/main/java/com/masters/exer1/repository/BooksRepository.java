package com.masters.exer1.repository;

import com.masters.exer1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Book, Integer>
{
}
