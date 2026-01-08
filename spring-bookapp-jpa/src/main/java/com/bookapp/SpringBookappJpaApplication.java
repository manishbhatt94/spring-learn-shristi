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

		BookDto bookDto1 = new BookDto(null, "Animal Farm", 399.0, "George Orwell", "Satire",
				LocalDate.of(1945, 8, 17));
		bookService.addBook(bookDto1);

		BookDto bookDto2 = new BookDto(null, "The Lord of the Rings", 999.0, "J.R.R. Tolkien", "Fantasy",
				LocalDate.of(1954, 7, 29));
		bookService.addBook(bookDto2);

		bookService.getAll().forEach(System.out::println);

	}

}
