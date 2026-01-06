package com.bookapp.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.service.IBookService;
import com.bookapp.util.BookDetails;

@Component
public class Client {

	private final Scanner scanner;

	private final IBookService bookService;

	// Either "bookServiceStreamsImpl" or "bookServiceImpl"
	public Client(@Qualifier("bookServiceStreamsImpl") IBookService bookService) {
		scanner = new Scanner(System.in);
		this.bookService = bookService;
	}

	public void runApp() {
		System.out.println("Welcome to 'The Stream Reader' Book App!\n");
		showAppOptionMenu();

		while (true) {
			AppMenuOption choice = null;
			try {
				choice = getMenuChoice();
				handleUserChoice(choice);
			} catch (IllegalArgumentException e) {
				// IllegalArgumentException throw by
				// Enum.valueOf & also handleUserChoice
				System.out.println("Option entered is not valid. Try again!");
				e.printStackTrace();
				continue;
			}
		}
	}

	private void showAppOptionMenu() {
		System.out.println("'The Stream Reader' Book App - Options Menu");
		System.out.println(
				"Check the below options menu to use our app.\n" + "Enter one of the option's code to proceed:\n");

		for (AppMenuOption menuOption : AppMenuOption.values()) {
			System.out.printf("[Option: %s] %s%n", menuOption.name(), menuOption.optionDesc);
		}
	}

	private AppMenuOption getMenuChoice() {
		System.out.println("\nEnter option code:");
		String input = scanner.nextLine().trim().toUpperCase();
		AppMenuOption choice = AppMenuOption.valueOf(input);
		return choice;
	}

	private void handleUserChoice(AppMenuOption choice) {
		System.out.println("\n" + choice.optionDesc);
		if (choice.optionSubDesc != null) {
			System.out.println(choice.optionSubDesc);
		}

		try {
			switch (choice) {
			case LIST_ALL: {
				BookDetails.printEntriesList(bookService.getAll());
				break;
			}

			case LIST_ALL_AUTHORS: {
				List<String> authors = bookService.getAllAuthors();
				System.out.println("\nList of all authors:");
				BookDetails.printEntriesList(authors);
				break;
			}

			case LIST_BY_AUTHOR: {
				String author = scanner.nextLine().trim();
				System.out.printf("%nList of books by author '%s':", author);
				BookDetails.printEntriesList(bookService.getByAuthorContains(author));
				break;
			}

			case LIST_BY_CATEGORY: {
				String category = scanner.nextLine().trim();
				System.out.printf("%nList of books by category '%s':%n", category);
				BookDetails.printEntriesList(bookService.getByCategory(category));
				break;
			}

			case LIST_BY_MAX_PRICE: {
				double maxPrice = scanner.nextDouble();
				scanner.nextLine();
				System.out.printf("%nBook titles (only titles) with price less or equal to ₹%.2f:%n", maxPrice);
				BookDetails.printEntriesList(bookService.getByPriceLessThan(maxPrice));
				break;
			}

			case LIST_BY_PUBLISH_YEAR: {
				int publishYear = scanner.nextInt();
				scanner.nextLine();
				System.out.printf("%nList of books books published in year %d:%n", publishYear);
				BookDetails.printEntriesList(bookService.getByDatePublished(publishYear));
				break;
			}

			case LIST_BY_AUTHOR_CATEGORY: {
				String author = scanner.nextLine().trim();
				String category = scanner.nextLine().trim();
				System.out.printf("%nList of books by author '%s' & under category '%s':%n", author, category);
				BookDetails.printEntriesList(bookService.getByAuthorContainsAndCategory(author, category));
				break;
			}

			case GET_BY_ID: {
				int bookId = scanner.nextInt();
				scanner.nextLine();
				System.out.printf("%nFound below book with bookId=%d:%n", bookId);
				System.out.println(bookService.getById(bookId) + "\n");
				break;
			}

			case GET_BOOKS_COUNT_BY_AUTHOR: {
				String author = scanner.nextLine().trim();
				int booksCountByAuthor = bookService.getCountOfBooksByAuthor(author);
				System.out.printf("%nNo. of book(s) available authored by '%s' = %d.%n", author, booksCountByAuthor);
				break;
			}

			case GET_BOOKS_TOTAL_PRICE_BY_CATEGORY: {
				String category = scanner.nextLine().trim();
				double totalPriceByCategory = bookService.getTotalPrice(category);
				System.out.printf("%nSum of price of all book(s) available under category '%s' = ₹%.2f.%n", category,
						totalPriceByCategory);
				break;
			}

			case SHOW_MENU: {
				showAppOptionMenu();
				break;
			}

			case EXIT_APP: {
				System.out.println("Exiting App now!");
				scanner.close();
				System.exit(0);
				break;
			}

			default: {
				throw new IllegalArgumentException("Invalid choice.");
			}
			}
		} catch (BookNotFoundException e) {
			System.out.println("\nFilter criteria did not yield results. " + e.getMessage());
			System.out.println("Please check your input & re-enter details for this option again.");
			handleUserChoice(choice);
		}
	}

}
