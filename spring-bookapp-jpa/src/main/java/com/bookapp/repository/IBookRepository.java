package com.bookapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookapp.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

	// ======= Derived Queries =======
	// readBy, getBy, queryBy, findBy

	List<Book> findByAuthor(String author);

	List<Book> readByCategory(String category);

	List<Book> queryByCategoryAndPriceLessThanEqual(String category, Double price);

	// ======= Custom Queries =======

	// SELECT * FROM book WHERE author = 'Kathy' AND price < 1000;
	@Query("from Book b where b.author = ?1 and b.price < ?2")
	List<Book> findByAuthorPriceLessThan(String author, double price);

	@Query("from Book b where b.category = ?1 and title like %?2%")
	List<Book> findByCategoryTitleContains(String category, String title);

	// ======= Native Query =======

	@Query(value = "select * from book where cost > (select avg(b.cost) from book b)", nativeQuery = true)
	List<Book> findAboveAvgPrice();

	// ======= Named Queries =======

	@Query(name = "fetchByCategoryAuthor")
	List<Book> readByCatAuth(String category, String author);

	// ======= Named Native Query =======

	@Query(name = "fetchAllInDescIdOrder", nativeQuery = true)
	List<Book> findAllBooksInDescIdOrder();

}
