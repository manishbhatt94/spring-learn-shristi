package com.bookapp.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
// @Table(name = "BookDetails") // table name will be "book_details"
public class Book {

	@Id
	@GeneratedValue
	private Integer bookId;

	private String title;

	private Double price;

	private String author;

	private String category;

	private LocalDate datePublished;

}
