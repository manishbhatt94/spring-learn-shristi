package com.bookapp.model;

import java.time.LocalDate;

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
public class BookDto {

	private Integer bookId;

	private String title;

	private Double price;

	private String author;

	private String category;

	private LocalDate datePublished;

}
