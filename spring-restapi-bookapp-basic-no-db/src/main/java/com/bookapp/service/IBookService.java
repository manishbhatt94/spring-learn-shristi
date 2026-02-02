package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {

	List<Book> getAll();

	List<String> getAllAuthors();

	List<Book> getByAuthorContains(String author) throws BookNotFoundException;

	List<Book> getByCategory(String category) throws BookNotFoundException;

	List<String> getByPriceLessThan(double price) throws BookNotFoundException;

	List<Book> getByDatePublished(int year) throws BookNotFoundException;

	List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException;

	Book getById(int bookId) throws BookNotFoundException;

	int getCountOfBooksByAuthor(String author) throws BookNotFoundException;

	double getTotalPrice(String category) throws BookNotFoundException;

}
