package com.bookapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

@Service
public class BookServiceStreamsImpl implements IBookService {

	private BookDetails bookDetails;

	public BookServiceStreamsImpl(BookDetails bookDetails) {
		super();
		this.bookDetails = bookDetails;
	}

	@Override
	public List<Book> getAll() {
		return bookDetails.getBooks().stream().sorted().toList();
	}

	@Override
	public List<String> getAllAuthors() {
		return bookDetails.getBooks().stream().map(Book::getAuthor).distinct().sorted().toList();
	}

	@Override
	public List<Book> getByAuthorContains(String author) throws BookNotFoundException {
		return filterByAuthor(author).stream().sorted().toList();
	}

	private List<Book> filterByAuthor(String author) throws BookNotFoundException {
		String queriedAuthor = author.toLowerCase();
		List<Book> matches = bookDetails.getBooks().stream().filter(book -> {
			String bookAuthor = book.getAuthor().toLowerCase();
			return bookAuthor.contains(queriedAuthor);
		}).toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with author: '%s' not found.", author));
		}
		return matches;
	}

	@Override
	public List<Book> getByCategory(String category) throws BookNotFoundException {
		return filterByCategory(category).stream().sorted().toList();
	}

	private List<Book> filterByCategory(String category) throws BookNotFoundException {
		List<Book> matches = bookDetails.getBooks().stream()
				.filter(book -> book.getCategory().equalsIgnoreCase(category)).toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with category: '%s' not found.", category));
		}
		return matches;
	}

	@Override
	public List<String> getByPriceLessThan(double price) throws BookNotFoundException {
		List<String> matches = bookDetails.getBooks().stream().filter(book -> book.getPrice() <= price)
				.map(Book::getTitle).sorted().toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books with price up to ₹%.2f not found.", price));
		}
		return matches;
	}

	@Override
	public List<Book> getByDatePublished(int year) throws BookNotFoundException {
		List<Book> matches = bookDetails.getBooks().stream().filter(book -> book.getDatePublished().getYear() == year)
				.sorted().toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(
					String.format("Book Not Found: Books published in year: '%d' not found.", year));
		}
		return matches;
	}

	@Override
	public List<Book> getByAuthorContainsAndCategory(String author, String category) throws BookNotFoundException {
		String queriedAuthor = author.toLowerCase();
		List<Book> matches = bookDetails.getBooks().stream().filter(book -> {
			String bookAuthor = book.getAuthor().toLowerCase();
			return bookAuthor.contains(queriedAuthor) && book.getCategory().equalsIgnoreCase(category);
		}).toList();
		if (matches.isEmpty()) {
			throw new BookNotFoundException(String.format(
					"Book Not Found: Books with author: '%s' & under category: '%s' not found.", author, category));
		}
		return matches;
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		return bookDetails.getBooks().stream().filter(book -> book.getBookId() == bookId).findFirst()
				.orElseThrow(() -> new BookNotFoundException(
						String.format("Book Not Found: Book with ID: '%d' not found.", bookId)));
	}

	@Override
	public int getCountOfBooksByAuthor(String author) throws BookNotFoundException {
		return filterByAuthor(author).size();
	}

	@Override
	public double getTotalPrice(String category) throws BookNotFoundException {
		return filterByCategory(category).stream().mapToDouble(Book::getPrice).sum();
	}

}