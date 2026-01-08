package com.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

}
