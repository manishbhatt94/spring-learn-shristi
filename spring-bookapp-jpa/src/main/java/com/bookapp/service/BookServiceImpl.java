package com.bookapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.model.BookDto;
import com.bookapp.repository.IBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService {

	private final ModelMapper mapper;
	private final IBookRepository repository;

	@Override
	public void addBook(BookDto bookDto) {
		Book book = mapper.map(bookDto, Book.class);
		// Cases handled by .save(<entity>) method:
		// -> If the entity does not have ID, then
		// ---- auto-generate the ID,
		// ---- and create a new record.
		// -> If the entity has an ID, then
		// ----> check in DB - if a record with this ID is available
		// -------> If available, then update that record.
		// -------> If not available, then create a new record.
		repository.save(book);
	}

	@Override
	public void updateBook(BookDto bookDto) {
		// It is a must that `bookDto` includes an ID property
		// corresponding to which, a record exists in the table.
		// If that is so, the record will get updated.
		// If not, then a new record will get created.
		Book book = mapper.map(bookDto, Book.class);
		repository.save(book);
	}

	@Override
	public void deleteBook(int bookId) {
		// .CrudRepository.deleteById(Integer id)
		// Deletes the entity with the given id.
		// If the entity is not found in the persistence store it is silently ignored.
		//
		// Parameters:
		// id must not be null.
		repository.deleteById(bookId);
	}

	@Override
	public List<BookDto> getAll() {
		List<Book> books = repository.findAll();
		return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
	}

	@Override
	public BookDto getById(int bookId) throws BookNotFoundException {
		Optional<Book> bookOpt = repository.findById(bookId);
		if (bookOpt.isPresent()) {
			Book book = bookOpt.get();
			return mapper.map(book, BookDto.class);
		}
		throw new BookNotFoundException("Invalid ID: " + bookId);
	}

	@Override
	public List<BookDto> getByAuthor(String author) throws BookNotFoundException {
		List<Book> books = repository.findByAuthor(author);
		return toBookDtoList(books, String.format("Books by author: %s not found.", author));
	}

	@Override
	public List<BookDto> getByCategory(String category) throws BookNotFoundException {
		List<Book> books = repository.readByCategory(category);
		return toBookDtoList(books, String.format("Books by category: %s not found.", category));
	}

	@Override
	public List<BookDto> getByCategoryUptoPrice(String category, double price) throws BookNotFoundException {
		List<Book> books = repository.queryByCategoryAndPriceLessThanEqual(category, price);
		return toBookDtoList(books,
				String.format("Books by category: %s & price upto: ₹%.2f not found.", category, price));
	}

	@Override
	public List<BookDto> getByAuthorPrice(String author, double price) {
		List<Book> books = repository.findByAuthorPriceLessThan(author, price);
		return toBookDtoList(books,
				String.format("Books by author: %s & price less than: ₹%.2f not found.", author, price));
	}

	@Override
	public List<BookDto> getByCategoryTitleContains(String category, String title) throws BookNotFoundException {
		List<Book> books = repository.findByCategoryTitleContains(category, title);
		return toBookDtoList(books,
				String.format("Books by category: %s & title containing: ₹%s not found.", category, title));
	}

	private List<BookDto> toBookDtoList(List<Book> books, String notFoundMessage) throws BookNotFoundException {
		if (books.isEmpty()) {
			throw new BookNotFoundException(notFoundMessage);
		}
		return books.stream().map(book -> mapper.map(book, BookDto.class)).toList();
	}

}
