package com.productapp.service;

import java.util.List;

import com.productapp.exception.CategoryNotFoundException;
import com.productapp.model.dtos.CategoryDto;

public interface ICategoryService {

	// CRUD operation

	void addCategory(CategoryDto categoryDto);

	void updateCategory(CategoryDto categoryDto);

	void deleteCategory(int categoryId);

	CategoryDto getById(int categoryId) throws CategoryNotFoundException;

	List<CategoryDto> getAll();

}
