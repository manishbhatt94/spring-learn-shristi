package com.productapp.controllers;

import java.time.LocalTime;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.enums.Delivery;
import com.productapp.model.enums.OfferType;
import com.productapp.model.enums.Payment;
import com.productapp.service.IProductService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/product-api/v1")
@RestController
public class ProductController {

	private final IProductService productService;

	// POST http://localhost:8081/product-api/v1/products
	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED.value()).build();
	}

	// PUT http://localhost:8081/product-api/v1/products
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto) {
		productService.updateProduct(productDto);
		return ResponseEntity.accepted().build();
	}

	// DELETE http://localhost:8081/product-api/v1/products/productId/1
	@DeleteMapping("/products/productId/{productId}")
	ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.ok().build();
	}

	// GET http://localhost:8081/product-api/v1/products/productId/1
	@GetMapping("/products/productId/{productId}")
	ResponseEntity<ProductDto> getById(@PathVariable int productId) throws ProductNotFoundException {
		ProductDto productDto = productService.getById(productId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returns a product by ID");
		headers.add("timestamp", LocalTime.now().toString());
		return new ResponseEntity<>(productDto, headers, HttpStatusCode.valueOf(200));
	}

	// GET http://localhost:8081/product-api/v1/products
	@GetMapping("/products")
	ResponseEntity<List<ProductDto>> getAll() {
		List<ProductDto> products = productService.getAll();
		HttpHeaders headers = new HttpHeaders();
		headers.add("info", "returns a list of products");
		headers.add("timestamp", LocalTime.now().toString());
		return ResponseEntity.status(HttpStatusCode.valueOf(200)).headers(headers).body(products);
	}

	// GET
	// http://localhost:8081/product-api/v1/products/category?categoryname=sports
	@GetMapping("/products/category")
	ResponseEntity<List<ProductDto>> getByCategory(@RequestParam String categoryname) {
		List<ProductDto> products = productService.getByCategory(categoryname);
		return ResponseEntity.ok(products);
	}

	ResponseEntity<List<ProductDto>> getByBrandAndPayType(String brand, Payment paymentType) {
		return null;
	}

	ResponseEntity<List<ProductDto>> getByColor(String color) {
		return null;
	}

	ResponseEntity<List<ProductDto>> getByCategoryAndDelivery(String category, Delivery delivery) {
		return null;
	}

	ResponseEntity<List<ProductDto>> getByNameContains(String name) {
		return null;
	}

	ResponseEntity<List<ProductDto>> getByNameAndOfferType(String name, OfferType offerType) {
		return null;
	}

}
