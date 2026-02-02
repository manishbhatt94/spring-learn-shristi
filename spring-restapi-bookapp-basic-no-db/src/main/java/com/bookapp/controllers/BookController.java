package com.bookapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.Book;
import com.bookapp.service.IBookService;

@RestController
@RequestMapping("/book-api/v1")
public class BookController {

	@Autowired
	@Qualifier("bookServiceStreamsImpl")
	private IBookService bookService;

	// http://localhost:8080/book-api/v1/books
	@GetMapping("/books")
	List<Book> getAll() {
		return bookService.getAll();
	}

	// http://localhost:8080/book-api/v1/authors
	@GetMapping("/authors")
	List<String> getAllAuthors() {
		return bookService.getAllAuthors();
	}

	// http://localhost:8080/book-api/v1/books/author?author=orwell
	@GetMapping("/books/author")
	List<Book> getByAuthorContains(@RequestParam String author) {
		return bookService.getByAuthorContains(author);
	}

	// http://localhost:8080/book-api/v1/books/category?cat=thriller
	@GetMapping("/books/category")
	List<Book> getByCategory(@RequestParam("cat") String category) {
		return bookService.getByCategory(category);
	}

	// http://localhost:8080/book-api/v1/books/price?price-lte=520
	@GetMapping("/books/price")
	List<String> getByPriceLessThan(@RequestParam("price-lte") double price) {
		return bookService.getByPriceLessThan(price);
	}

	// http://localhost:8080/book-api/v1/books/year?year=1998
	@GetMapping("/books/year")
	List<Book> getByDatePublished(@RequestParam int year) {
		return bookService.getByDatePublished(year);
	}

	// http://localhost:8080/book-api/v1/books/property?author=martin&cat=fantasy
	@GetMapping("/books/property")
	List<Book> getByAuthorContainsAndCategory(@RequestParam String author, @RequestParam("cat") String category) {
		return bookService.getByAuthorContainsAndCategory(author, category);
	}

	// http://localhost:8080/book-api/v1/books/bookId/103
	@GetMapping("/books/bookId/{bookId}")
	Book getById(@PathVariable int bookId) {
		return bookService.getById(bookId);
	}

	// http://localhost:8080/book-api/v1/books/count/author?author=Rowling
	@GetMapping("/books/count/author")
	int getCountOfBooksByAuthor(@RequestParam String author) {
		return bookService.getCountOfBooksByAuthor(author);
	}

	// http://localhost:8080/book-api/v1/books/total-price/category/Classic
	@GetMapping("/books/total-price/category/{cat}")
	double getTotalPrice(@PathVariable("cat") String category) {
		return bookService.getTotalPrice(category);
	}

}
