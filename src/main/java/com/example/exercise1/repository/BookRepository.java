package com.example.exercise1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exercise1.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
