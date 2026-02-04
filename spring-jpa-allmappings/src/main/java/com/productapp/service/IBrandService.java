package com.productapp.service;

import java.util.List;

import com.productapp.exception.BrandNotFoundException;
import com.productapp.model.dtos.BrandDto;

public interface IBrandService {

	// CRUD operation

	void addBrand(BrandDto brandDto);

	void updateBrand(BrandDto brandDto);

	void deleteBrand(int brandId);

	BrandDto getById(int brandId) throws BrandNotFoundException;

	List<BrandDto> getAll();

}
