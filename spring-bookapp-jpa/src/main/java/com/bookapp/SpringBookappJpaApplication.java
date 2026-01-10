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
		bookService.getAll().forEach(System.out::println);
		System.out.println();

		System.out.println("--------- By Author ------------");
		bookService.getByAuthor("George Orwell").forEach(System.out::println);
		System.out.println();

		System.out.println("--------- By Category ------------");
		bookService.getByCategory("Thriller").forEach(System.out::println);
		System.out.println();

		System.out.println("--------- By Category & Upto Price ------------");
		bookService.getByCategoryUptoPrice("Fantasy", 750).forEach(System.out::println);
		System.out.println();

		System.out.println("--------- By Author & Upto Price ------------");
		bookService.getByAuthorPrice("Dan Brown", 600).forEach(System.out::println);
		System.out.println();

		System.out.println("--------- By Category & Title contains ------------");
		bookService.getByCategoryTitleContains("Thriller", "Girl").forEach(System.out::println);
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
