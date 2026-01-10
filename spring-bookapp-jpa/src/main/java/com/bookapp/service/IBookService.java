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

	List<BookDto> getByAuthor(String author) throws BookNotFoundException;

	List<BookDto> getByCategory(String category) throws BookNotFoundException;

	List<BookDto> getByCategoryUptoPrice(String category, double price) throws BookNotFoundException;

	List<BookDto> getByAuthorPrice(String author, double price) throws BookNotFoundException;

	List<BookDto> getByCategoryTitleContains(String category, String title) throws BookNotFoundException;

}
