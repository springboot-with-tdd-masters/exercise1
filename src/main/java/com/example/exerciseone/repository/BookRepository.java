package com.example.exerciseone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.exerciseone.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
