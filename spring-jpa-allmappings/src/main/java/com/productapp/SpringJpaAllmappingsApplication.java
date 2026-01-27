package com.productapp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.dtos.FeatureDto;
import com.productapp.model.dtos.OfferDto;
import com.productapp.model.dtos.ProductDto;
import com.productapp.model.enums.OfferType;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringJpaAllmappingsApplication implements CommandLineRunner {

	@Autowired
	private IProductService productService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAllmappingsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// 1 to 1
		FeatureDto featureDto = new FeatureDto(null, "This can be used by kids", "Rubber", "Maroon");
		// 1 to Many
		OfferDto offerDto1 = new OfferDto(null, OfferType.BO.getOfferName(), "Upto 5% offer");
		OfferDto offerDto2 = new OfferDto(null, OfferType.CB.getOfferName(), "Upto Rs. 1200/- off");
		OfferDto offerDto3 = new OfferDto(null, OfferType.NCE.getOfferName(), "No cost EMI available");

		// add the offers to a list
		List<OfferDto> offersList = Arrays.asList(offerDto1, offerDto2, offerDto3);

		ProductDto productDto = new ProductDto(null, "Basketball", 1200, 4.5, featureDto, offersList);
		productService.addProduct(productDto);

		System.out.println();
		System.out.println(productService.getById(1));
		System.out.println();
		productService.getAll().forEach(System.out::println);

	}

}
