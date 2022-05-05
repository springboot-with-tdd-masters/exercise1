package com.csv.bookscrudexercise1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csv.bookscrudexercise1.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
