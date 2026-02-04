package com.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productapp.model.entities.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

}
