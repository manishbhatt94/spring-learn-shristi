package com.productapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.dtos.BrandDto;
import com.productapp.model.dtos.CategoryDto;
import com.productapp.model.dtos.FeatureDto;
import com.productapp.model.dtos.OfferDto;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.enums.Delivery;
import com.productapp.model.enums.OfferType;
import com.productapp.model.enums.Payment;
import com.productapp.service.IBrandService;
import com.productapp.service.ICategoryService;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringJpaAllmappingsApplication implements CommandLineRunner {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IBrandService brandService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAllmappingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// ======= 1 to 1 (Product - Feature) =========

		// A Feature is tied to a Product (dependent).
		// So when adding a Product, the Feature is also added via Cascade.ALL
		FeatureDto featureDto1 = new FeatureDto(null, "This can be used by kids", "Rubber", "Maroon");
		FeatureDto featureDto2 = new FeatureDto(null, "Foldable phone of the future", "Gorilla Glass 5", "Space Grey");

		// ======= 1 to Many (Product - Offer) =========

		// An Offer is tied to a Product (dependent).
		// So when adding a Product, the Offer is also added via Cascade.ALL

		OfferDto offerDto1 = new OfferDto(null, OfferType.BO.getOfferName(), "Upto 5% offer");
		OfferDto offerDto2 = new OfferDto(null, OfferType.CB.getOfferName(), "Upto Rs. 1200/- off");
		OfferDto offerDto3 = new OfferDto(null, OfferType.NCE.getOfferName(), "No cost EMI available");
		OfferDto offerDto4 = new OfferDto(null, OfferType.PO.getOfferName(), "Flat Rs. 150/- worth Sodexo cash");
		OfferDto offerDto5 = new OfferDto(null, OfferType.BO.getOfferName(), "SBI Credit Card Rs. 2000/- discount");

		// ======= Many to Many (Product - Category) =========

		CategoryDto categoryDto1 = new CategoryDto(null, "Sports");
		CategoryDto categoryDto2 = new CategoryDto(null, "Kids");
		CategoryDto categoryDto3 = new CategoryDto(null, "Electronics");
		CategoryDto categoryDto4 = new CategoryDto(null, "Mobiles");

		// Add categories (Category is independent of Product).
		// So we add it separately.
		categoryService.addCategory(categoryDto1);
		categoryService.addCategory(categoryDto2);
		categoryService.addCategory(categoryDto3);
		categoryService.addCategory(categoryDto4);

		// Get category by ID
		CategoryDto catDto1 = categoryService.getById(150);
		CategoryDto catDto2 = categoryService.getById(151);
		CategoryDto catDto3 = categoryService.getById(152);
		CategoryDto catDto4 = categoryService.getById(153);

		// ======= Many to One (Product - Brand) =========

		BrandDto brandDto1 = new BrandDto(null, "Adidas");
		BrandDto brandDto2 = new BrandDto(null, "Samsung");

		// Add brands (Brand is independent of Product).
		// So we add it separately.
		brandService.addBrand(brandDto1);
		brandService.addBrand(brandDto2);

		// Get brand by ID
		BrandDto brandOne = brandService.getById(20);
		BrandDto brandTwo = brandService.getById(21);

		// ======= ElementCollection =========

		// ElementCollection's are not a separate entity.
		// They get added to their CollectionTable, and linked with a specific Product
		// when that specific Product is added.
		List<String> deliveryTypes1 = Arrays.asList(Delivery.PRIME.name(), Delivery.STANDARD.name());
		List<String> paymentModes1 = Arrays.asList(Payment.COD.name(), Payment.CARD.name());
		List<String> deliveryTypes2 = Arrays.asList(Delivery.AMAZON.name());
		List<String> paymentModes2 = Arrays.asList(Payment.NB.name(), Payment.UPI.name());

		// ======= Add Product 1 =========

		ProductDto productDto1 = new ProductDto(null, "Basketball", 1200, 4.5, featureDto1,
				Arrays.asList(offerDto1, offerDto2, offerDto3), Arrays.asList(catDto1, catDto2), brandOne,
				deliveryTypes1, paymentModes1);
		productService.addProduct(productDto1);

		// ======= Add Product 2 =========

		ProductDto productDto2 = new ProductDto(null, "Galaxy Fold S35 Plus", 98000, 4.1, featureDto2,
				Arrays.asList(offerDto4, offerDto5), Arrays.asList(catDto3, catDto4), brandTwo, deliveryTypes2,
				paymentModes2);
		productService.addProduct(productDto2);

		System.out.println("\n----------- productService.getById -----------");
		System.out.println("> productId = " + 1);
		System.out.println(productService.getById(1));
		System.out.println();

		System.out.println("\n----------- productService.getAll -----------");
		productService.getAll().forEach(System.out::println);
		System.out.println();

	}

}
