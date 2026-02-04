package com.productapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.model.dtos.CategoryDto;
import com.productapp.model.entities.Category;
import com.productapp.repository.ICategoryRepository;
import com.productapp.service.ICategoryService;
import com.productapp.util.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

	private final ICategoryRepository categoryRepository;
	private final ProductMapper productMapper;

	@Override
	public void addCategory(CategoryDto categoryDto) {
		Category category = productMapper.convertToCategoryEntity(categoryDto);
		categoryRepository.save(category);
	}

	@Override
	public void updateCategory(CategoryDto categoryDto) {
		Category category = productMapper.convertToCategoryEntity(categoryDto);
		categoryRepository.save(category);
	}

	@Override
	public void deleteCategory(int categoryId) {
		categoryRepository.deleteById(categoryId);
	}

	@Override
	public CategoryDto getById(int categoryId) {
		return categoryRepository.findById(categoryId).map(productMapper::convertToCategoryDto).orElse(null);
	}

	@Override
	public List<CategoryDto> getAll() {
		return categoryRepository.findAll().stream().map(productMapper::convertToCategoryDto).toList();
	}

}
