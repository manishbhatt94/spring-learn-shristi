package com.bookapp.model;

import java.time.LocalDate;

public class Book implements Comparable<Book> {

	private String title;
	private Integer bookId;
	private Double price;
	private String author;
	private String category;
	private LocalDate datePublished;

	public Book() {
		super();
	}

	public Book(String title, Integer bookId, Double price, String author, String category, LocalDate datePublished) {
		super();
		this.title = title;
		this.bookId = bookId;
		this.price = price;
		this.author = author;
		this.category = category;
		this.datePublished = datePublished;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(LocalDate datePublished) {
		this.datePublished = datePublished;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", bookId=" + bookId + ", price=" + price + ", author=" + author + ", category="
				+ category + ", datePublished=" + datePublished + "]";
	}

	@Override
	public int compareTo(Book o) {
		return title.compareTo(o.getTitle());
	}

}
