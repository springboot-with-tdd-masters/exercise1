package com.magenic.mobog.exercise1app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magenic.mobog.exercise1app.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
