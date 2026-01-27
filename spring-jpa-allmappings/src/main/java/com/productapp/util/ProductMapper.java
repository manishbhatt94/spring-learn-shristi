package com.productapp.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productapp.model.dtos.ProductDto;
import com.productapp.model.entities.Product;

@Component
public class ProductMapper {
	
	@Autowired
	private ModelMapper mapper;

	public ProductDto convertToDto(Product product){
		return mapper.map(product, ProductDto.class);
	}
	
	public Product convertToEntity(ProductDto productDto){
		return mapper.map(productDto, Product.class);
	}
	
}
