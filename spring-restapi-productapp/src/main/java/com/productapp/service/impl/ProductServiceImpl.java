package com.productapp.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exception.BrandNotFoundException;
import com.productapp.exception.CategoryNotFoundException;
import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.dtos.CategoryDto;
import com.productapp.model.dtos.FeatureDto;
import com.productapp.model.dtos.OfferDto;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.entities.Brand;
import com.productapp.model.entities.Category;
import com.productapp.model.entities.Feature;
import com.productapp.model.entities.Offer;
import com.productapp.model.entities.Product;
import com.productapp.model.enums.Delivery;
import com.productapp.model.enums.OfferType;
import com.productapp.model.enums.Payment;
import com.productapp.repository.IBrandRepository;
import com.productapp.repository.ICategoryRepository;
import com.productapp.repository.IProductRepository;
import com.productapp.service.IProductService;
import com.productapp.util.ProductMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

	private final IProductRepository productRepository;
	private final ICategoryRepository categoryRepository;
	private final IBrandRepository brandRepository;
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
	@Transactional
	public void updateProductVerbose(ProductDto productDto) {
		// Step 1: Fetch existing product (with all associations)
		Integer dtoProductId = productDto.getProductId();
		Product existingProduct = productRepository.findById(dtoProductId)
				.orElseThrow(() -> new ProductNotFoundException(
						"Product not found: Product with ID " + dtoProductId + " not found"));

		// Step 2: Update basic fields
		existingProduct.setProductName(productDto.getProductName());
		existingProduct.setPrice(productDto.getPrice());
		existingProduct.setRating(productDto.getRating());

		// Step 3: Handle Feature (OneToOne)
		updateFeature(existingProduct, productDto.getFeature());

		// Step 4: Handle Offers (OneToMany)
		updateOffers(existingProduct, productDto.getOffers());

		// Step 5: Handle Categories (ManyToMany)
		if (productDto.getCategories() != null) {
			List<Integer> categoryIds = productDto.getCategories().stream().map(CategoryDto::getCategoryId)
					.collect(Collectors.toList());

			List<Category> categories = categoryRepository.findAllById(categoryIds);

			if (categories.size() != categoryIds.size()) {
				throw new CategoryNotFoundException("One or more categories not found");
			}

			existingProduct.setCategories(categories);
		}

		// Step 6: Handle Brand (ManyToOne)
		if (productDto.getBrand() != null && productDto.getBrand().getBrandId() != null) {
			Integer dtoBrandId = productDto.getBrand().getBrandId();
			Integer existingBrandId = existingProduct.getBrand().getBrandId();
			if (!dtoBrandId.equals(existingBrandId)) { // if a different brandId has been provided in the request
				Brand brand = brandRepository.findById(dtoBrandId).orElseThrow(() -> new BrandNotFoundException(
						"Brand not found: Brand with ID " + dtoBrandId + " not found"));
				existingProduct.setBrand(brand);
			}
		}

		// Step 7: Handle ElementCollections
		if (productDto.getDeliveryTypes() != null) {
			existingProduct.getDeliveryTypes().clear();
			existingProduct.getDeliveryTypes().addAll(productDto.getDeliveryTypes());
		}

		if (productDto.getPaymentModes() != null) {
			existingProduct.getPaymentModes().clear();
			existingProduct.getPaymentModes().addAll(productDto.getPaymentModes());
		}

		// Step 8: Save (JPA will handle cascades)
		productRepository.save(existingProduct);
	}

	private void updateFeature(Product existingProduct, FeatureDto featureDto) {
		if (featureDto == null) {
			return;
		}

		Feature existingFeature = existingProduct.getFeature();

		// If DTO has an ID, we're updating existing
		if (featureDto.getFeatureId() != null) {
			if (existingFeature == null || !existingFeature.getFeatureId().equals(featureDto.getFeatureId())) {
				throw new IllegalArgumentException("Feature ID mismatch");
			}

			// Update existing managed feature
			existingFeature.setDescription(featureDto.getDescription());
			existingFeature.setColor(featureDto.getColor());
			existingFeature.setMaterial(featureDto.getMaterial());
		} else {
			// No ID = creating new feature
			Feature newFeature = new Feature();
			newFeature.setDescription(featureDto.getDescription());
			newFeature.setColor(featureDto.getColor());
			newFeature.setMaterial(featureDto.getMaterial());

			existingProduct.setFeature(newFeature);
			// Old feature will be deleted due to orphanRemoval
		}
	}

	private void updateOffers(Product existingProduct, List<OfferDto> offerDtos) {
		if (offerDtos == null) {
			return;
		}

		// Build a map of existing offers by ID
		Map<Integer, Offer> existingOffersMap = existingProduct.getOffers().stream()
				.collect(Collectors.toMap(Offer::getOfferId, offer -> offer));

		// Clear the list (but don't let orphanRemoval trigger yet)
		List<Offer> updatedOffers = new ArrayList<>();

		for (OfferDto offerDto : offerDtos) {
			if (offerDto.getOfferId() != null && existingOffersMap.containsKey(offerDto.getOfferId())) {
				// Update existing offer
				Offer existingOffer = existingOffersMap.get(offerDto.getOfferId());
				existingOffer.setOfferName(offerDto.getOfferName());
				existingOffer.setDescription(offerDto.getDescription());
				updatedOffers.add(existingOffer);
			} else {
				// Create new offer
				Offer newOffer = new Offer();
				newOffer.setOfferName(offerDto.getOfferName());
				newOffer.setDescription(offerDto.getDescription());
				updatedOffers.add(newOffer);
			}
		}

		// Replace the collection
		existingProduct.getOffers().clear();
		existingProduct.getOffers().addAll(updatedOffers);
		// Offers not in updatedOffers are orphaned and will be deleted
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

	@Override
	public List<ProductDto> getByBrandAndPayType(String brand, Payment paymentType) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByColor(String color) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByCategoryAndDelivery(String category, Delivery delivery)
			throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByNameContains(String name) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByNameAndOfferType(String name, OfferType offerType) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	private <X extends RuntimeException> List<ProductDto> toDtoListIfEmptyThrow(List<Product> products,
			Supplier<? extends X> exceptionSupplier) throws X {
		if (products.isEmpty()) {
			throw exceptionSupplier.get();
		}
		return products.stream().map(productMapper::convertToProductDto).toList();
	}

}
