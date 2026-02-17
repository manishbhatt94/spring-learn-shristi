package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "select p from Product p join p.categories c where c.categoryName = ?1")
	List<Product> findByCategory(String category);

}
