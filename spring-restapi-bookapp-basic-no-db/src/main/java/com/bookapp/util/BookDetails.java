package com.bookapp.util;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;

@Component
public class BookDetails {

	private final List<Book> books;

	public BookDetails() {
		super();
		this.books = getInitialBooks();
	}

	public List<Book> getBooks() {

		return books;
	}

	public static <T> void printEntriesList(List<T> entries) {
		System.out.println();
		for (T entry : entries) {
			System.out.println(entry);
		}
		System.out.println();
	}

	private List<Book> getInitialBooks() {
		return List.of(
				// Classics
				new Book("To Kill a Mockingbird", 101, 499.0, "Harper Lee", "Classic", LocalDate.of(1960, 7, 11)),
				new Book("1984", 102, 450.0, "George Orwell", "Dystopian", LocalDate.of(1949, 6, 8)),
				new Book("Animal Farm", 103, 399.0, "George Orwell", "Satire", LocalDate.of(1945, 8, 17)),
				new Book("The Great Gatsby", 104, 399.0, "F. Scott Fitzgerald", "Classic", LocalDate.of(1925, 4, 10)),
				new Book("Pride and Prejudice", 105, 350.0, "Jane Austen", "Romance", LocalDate.of(1813, 1, 28)),
				new Book("The Catcher in the Rye", 106, 420.0, "J.D. Salinger", "Classic", LocalDate.of(1951, 7, 16)),

				// Tolkien (multiple)
				new Book("The Hobbit", 107, 550.0, "J.R.R. Tolkien", "Fantasy", LocalDate.of(1937, 9, 21)),
				new Book("The Lord of the Rings", 108, 999.0, "J.R.R. Tolkien", "Fantasy", LocalDate.of(1954, 7, 29)),
				new Book("The Silmarillion", 109, 850.0, "J.R.R. Tolkien", "Fantasy", LocalDate.of(1977, 9, 15)),

				// Rowling (multiple)
				new Book("Harry Potter and the Philosopher's Stone", 110, 699.0, "J.K. Rowling", "Fantasy",
						LocalDate.of(1997, 6, 26)),
				new Book("Harry Potter and the Chamber of Secrets", 111, 720.0, "J.K. Rowling", "Fantasy",
						LocalDate.of(1998, 7, 2)),
				new Book("Harry Potter and the Prisoner of Azkaban", 112, 750.0, "J.K. Rowling", "Fantasy",
						LocalDate.of(1999, 7, 8)),

				// George R.R. Martin (multiple)
				new Book("A Game of Thrones", 113, 850.0, "George R.R. Martin", "Fantasy", LocalDate.of(1996, 8, 6)),
				new Book("A Clash of Kings", 114, 880.0, "George R.R. Martin", "Fantasy", LocalDate.of(1998, 11, 16)),
				new Book("A Storm of Swords", 115, 920.0, "George R.R. Martin", "Fantasy", LocalDate.of(2000, 8, 8)),

				// Dan Brown (multiple)
				new Book("The Da Vinci Code", 116, 600.0, "Dan Brown", "Thriller", LocalDate.of(2003, 3, 18)),
				new Book("Angels & Demons", 117, 580.0, "Dan Brown", "Thriller", LocalDate.of(2000, 5, 1)),
				new Book("Inferno", 118, 640.0, "Dan Brown", "Thriller", LocalDate.of(2013, 5, 14)),

				// Other modern hits
				new Book("The Alchemist", 119, 450.0, "Paulo Coelho", "Philosophical", LocalDate.of(1988, 4, 15)),
				new Book("The Kite Runner", 120, 500.0, "Khaled Hosseini", "Drama", LocalDate.of(2003, 5, 29)),
				new Book("A Thousand Splendid Suns", 121, 520.0, "Khaled Hosseini", "Drama", LocalDate.of(2007, 5, 22)),
				new Book("Life of Pi", 122, 480.0, "Yann Martel", "Adventure", LocalDate.of(2001, 9, 11)),
				new Book("The Girl with the Dragon Tattoo", 123, 650.0, "Stieg Larsson", "Mystery",
						LocalDate.of(2005, 8, 1)),
				new Book("Gone Girl", 124, 620.0, "Gillian Flynn", "Thriller", LocalDate.of(2012, 6, 5)),
				new Book("The Fault in Our Stars", 125, 550.0, "John Green", "Young Adult", LocalDate.of(2012, 1, 10)),

				// Non-fiction / Self-help
				new Book("Sapiens: A Brief History of Humankind", 126, 799.0, "Yuval Noah Harari", "Non-Fiction",
						LocalDate.of(2011, 6, 4)),
				new Book("Homo Deus: A Brief History of Tomorrow", 127, 820.0, "Yuval Noah Harari", "Non-Fiction",
						LocalDate.of(2015, 9, 8)),
				new Book("Educated", 128, 720.0, "Tara Westover", "Memoir", LocalDate.of(2018, 2, 20)),
				new Book("Atomic Habits", 129, 599.0, "James Clear", "Self-Help", LocalDate.of(2018, 10, 16)),
				new Book("Rich Dad Poor Dad", 130, 400.0, "Robert Kiyosaki", "Finance", LocalDate.of(1997, 4, 1)));
	}
}
