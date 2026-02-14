package com.productapp.service.impl;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.entities.Product;
import com.productapp.repository.IProductRepository;
import com.productapp.service.IProductService;
import com.productapp.util.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productRepository;
	private final ProductMapper productMapper;

	@Override
	public void addProduct(ProductDto productDto) {
		Product product = productMapper.convertToProductEntity(productDto);
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		Product product = productMapper.convertToProductEntity(productDto);
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductDto> getAll() {
		return productRepository.findAll().stream().map(productMapper::convertToProductDto).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductDto getById(int productId) throws ProductNotFoundException {
		return productRepository.findById(productId).map(productMapper::convertToProductDto)
				.orElseThrow(() -> new ProductNotFoundException("Product with given ID not found"));
	}

	@Override
	public List<ProductDto> getByCategory(String category) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategory(category);
		return toDtoListIfEmptyThrow(products,
				() -> new ProductNotFoundException("Products with category: '" + category + "' not found"));
	}

	private <X extends RuntimeException> List<ProductDto> toDtoListIfEmptyThrow(List<Product> products,
			Supplier<? extends X> exceptionSupplier) throws X {
		if (products.isEmpty()) {
			throw exceptionSupplier.get();
		}
		return products.stream().map(productMapper::convertToProductDto).toList();
	}

}
