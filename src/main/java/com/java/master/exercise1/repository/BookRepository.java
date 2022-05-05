package com.java.master.exercise1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.master.exercise1.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
