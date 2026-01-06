package com.bookapp.main;

enum AppMenuOption {
	LIST_ALL("Show all books.", null), LIST_ALL_AUTHORS("Show all authors whose titles are available.", null),
	LIST_BY_AUTHOR("Show books by author name.", "Enter author name"),
	LIST_BY_CATEGORY("Show books by genre / category.",
			"Enter book genre / category (e.g. Fantasy, Thriller, Satire, Romance. etc.)"),
	LIST_BY_MAX_PRICE("Show book titles (only titles) with price less or equal to a particular value.",
			"Enter maximum price amount"),
	LIST_BY_PUBLISH_YEAR("Show books published in a particular year.", "Enter publish year"),
	LIST_BY_AUTHOR_CATEGORY("Show books by author belonging to a genre.",
			"Enter author name, & genre (in separate lines - first author & press enter, then genre & press enter"),
	GET_BY_ID("Find book by ID.", "Enter book ID"),
	GET_BOOKS_COUNT_BY_AUTHOR("Get count of books by author name.", "Enter author name"),
	GET_BOOKS_TOTAL_PRICE_BY_CATEGORY("Get sum of price of all books by category",
			"Enter book genre / category (e.g. Fantasy, Thriller, Satire, Romance. etc.)"),
	SHOW_MENU("Show App Menu again.", null), EXIT_APP("Exit App", null);

	String optionDesc;
	String optionSubDesc;

	private AppMenuOption(String optionDesc, String optionSubDesc) {
		this.optionDesc = optionDesc;
		this.optionSubDesc = optionSubDesc;
	}

}
