package com.productapp.service.impl;

import java.util.List;

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
		Product product = productMapper.convertToEntity(productDto);
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductDto> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(productMapper::convertToDto).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public ProductDto getById(int productId) throws ProductNotFoundException {
		return productRepository.findById(productId).map(productMapper::convertToDto)
				.orElseThrow(() -> new ProductNotFoundException("Product with given ID not found"));
	}

}
