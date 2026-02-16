package com.productapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.productapp.model.dtos.BrandDto;
import com.productapp.model.entities.Brand;
import com.productapp.repository.IBrandRepository;
import com.productapp.service.IBrandService;
import com.productapp.util.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements IBrandService {

	private final IBrandRepository brandRepository;
	private final ProductMapper productMapper;

	@Override
	public void addBrand(BrandDto brandDto) {
		Brand brand = productMapper.convertToBrandEntity(brandDto);
		brandRepository.save(brand);
	}

	@Override
	public void updateBrand(BrandDto brandDto) {
		Brand brand = productMapper.convertToBrandEntity(brandDto);
		brandRepository.save(brand);
	}

	@Override
	public void deleteBrand(int brandId) {
		brandRepository.deleteById(brandId);
	}

	@Override
	public BrandDto getById(int brandId) {
		return brandRepository.findById(brandId).map(productMapper::convertToBrandDto).orElse(null);
	}

	@Override
	public List<BrandDto> getAll() {
		return brandRepository.findAll().stream().map(productMapper::convertToBrandDto).toList();
	}

}
