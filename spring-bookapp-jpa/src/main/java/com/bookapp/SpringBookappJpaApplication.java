package com.bookapp;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bookapp.model.BookDto;
import com.bookapp.service.IBookService;

@SpringBootApplication
public class SpringBookappJpaApplication implements CommandLineRunner {

	@Autowired
	private IBookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBookappJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// populateData();

		String author = null;
		String category = null;
		String title = null;
		double price = 0.0;

		System.out.println("\n--------- All Books [getAll] ------------");
		bookService.getAll().forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- By Author [getByAuthor] ------------");
		author = "George Orwell";
		System.out.println(" > author = " + author);
		bookService.getByAuthor(author).forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- By Category [getByCategory] ------------");
		category = "Thriller";
		System.out.println(" > category = " + category);
		bookService.getByCategory(category).forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- By Category & Upto Price [getByCategoryUptoPrice] ------------");
		category = "Fantasy";
		price = 750.0;
		System.out.println(" > category = " + category);
		System.out.println(" > price = " + price);
		bookService.getByCategoryUptoPrice(category, price).forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- By Author & Upto Price [getByAuthorPrice] ------------");
		author = "Dan Brown";
		price = 600.0;
		System.out.println(" > author = " + author);
		System.out.println(" > price = " + price);
		bookService.getByAuthorPrice(author, price).forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- By Category & Title contains [getByCategoryTitleContains] ------------");
		category = "Thriller";
		title = "Girl";
		System.out.println(" > category = " + category);
		System.out.println(" > title = " + title);
		bookService.getByCategoryTitleContains(category, title).forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- By Price Above Avg [getByPriceAboveAvg] ------------");
		bookService.getByPriceAboveAvg().forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- By Category & Author [getByCategoryAuthor] ------------");
		category = "Satire";
		author = "George Orwell";
		System.out.println(" > category = " + category);
		System.out.println(" > author = " + author);
		bookService.getByCategoryAuthor(category, author).forEach(System.out::println);
		System.out.println();

		System.out.println("\n--------- All Books In Desc Id Order [getAllBooksInDescIdOrder] ------------");
		bookService.getAllBooksInDescIdOrder().forEach(System.out::println);
		System.out.println();// getSortedBooks

		System.out.println("\n--------- All Books Sorted In Specific Order [getSortedBooks] ------------");
		System.out.println(" > ORDER BY category ASC, cost DESC");
		bookService.getSortedBooks().forEach(System.out::println);
		System.out.println();

	}

	private void populateData() {
		BookDto bookDto = null;

		bookDto = new BookDto(null, "Animal Farm", 399.0, "George Orwell", "Satire", LocalDate.of(1945, 8, 17));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "The Lord of the Rings", 999.0, "J.R.R. Tolkien", "Fantasy",
				LocalDate.of(1954, 7, 29));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Harry Potter and the Philosopher's Stone", 699.0, "J.K. Rowling", "Fantasy",
				LocalDate.of(1997, 6, 26));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Harry Potter and the Chamber of Secrets", 720.0, "J.K. Rowling", "Fantasy",
				LocalDate.of(1998, 7, 2));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Harry Potter and the Prisoner of Azkaban", 750.0, "J.K. Rowling", "Fantasy",
				LocalDate.of(1999, 7, 8));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "A Clash of Kings", 880.0, "George R.R. Martin", "Fantasy",
				LocalDate.of(1998, 11, 16));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "The Da Vinci Code", 600.0, "Dan Brown", "Thriller", LocalDate.of(2003, 3, 18));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "1984", 450.0, "George Orwell", "Dystopian", LocalDate.of(1949, 6, 8));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Pride and Prejudice", 350.0, "Jane Austen", "Romance", LocalDate.of(1813, 1, 28));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "The Girl with the Dragon Tattoo", 650.0, "Stieg Larsson", "Mystery",
				LocalDate.of(2005, 8, 1));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Inferno", 640.0, "Dan Brown", "Thriller", LocalDate.of(2013, 5, 14));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Atomic Habits", 599.0, "James Clear", "Self-Help", LocalDate.of(2018, 10, 16));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Life of Pi", 480.0, "Yann Martel", "Adventure", LocalDate.of(2001, 9, 11));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Gone Girl", 620.0, "Gillian Flynn", "Thriller", LocalDate.of(2012, 6, 5));
		bookService.addBook(bookDto);

		bookDto = new BookDto(null, "Angels & Demons", 580.0, "Dan Brown", "Thriller", LocalDate.of(2000, 5, 1));
		bookService.addBook(bookDto);

	}

}
