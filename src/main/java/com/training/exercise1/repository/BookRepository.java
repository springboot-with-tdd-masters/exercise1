/**
 * 
 */
package com.training.exercise1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.exercise1.model.Book;

/**
 * @author michaeldelacruz
 *
 */

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

}
