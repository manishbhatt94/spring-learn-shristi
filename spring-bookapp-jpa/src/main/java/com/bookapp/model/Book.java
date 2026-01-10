package com.bookapp.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
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
@NamedQuery(name = "fetchByCategoryAuthor", query = "from Book b where b.category = ?1 and b.author = ?2")
public class Book {

	@Id
	@GeneratedValue
	private Integer bookId;

	private String title;

	@Column(name = "cost")
	private Double price;

	private String author;

	private String category;

	private LocalDate datePublished;

}
