package com.bookapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.BookDto;

@Service
public interface IBookService {

	void addBook(BookDto bookDto);

	void updateBook(BookDto bookDto);

	void deleteBook(int bookId);

	List<BookDto> getAll();

	BookDto getById(int bookId) throws BookNotFoundException;

}
