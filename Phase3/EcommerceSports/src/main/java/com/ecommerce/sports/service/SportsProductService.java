package com.ecommerce.sports.service;

import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecommerce.sports.models.SportsProducts;
import com.ecommerce.sports.repository.SportsProductRepository;

@Service
public class SportsProductService {

	private final SportsProductRepository productRepository;
	
	@Autowired
	public SportsProductService (SportsProductRepository productRepository ) {
		this.productRepository=productRepository;
	}
	
	public SportsProducts updateProductById(int productId, SportsProducts newProduct) {
		SportsProducts oldProduct = productRepository.findById(productId).get();
		oldProduct.setProductName(newProduct.getProductName());
		oldProduct.setProductBrand(newProduct.getProductBrand());
		oldProduct.setProductCategory(newProduct.getProductCategory());
		oldProduct.setProductPrice(newProduct.getProductPrice());
		oldProduct.setProductColor(newProduct.getProductColor());
		oldProduct.setProductCreatedDate(newProduct.getProductCreatedDate());
		oldProduct.setProductDiscount(newProduct.getProductDiscount());
		oldProduct.setProductQuantity(newProduct.getProductQuantity());
		productRepository.save(oldProduct);
		return newProduct;
	}
	
	public List<SportsProducts> findAllProductsByCategory(String category) {
		return productRepository.findAllProductsByCategory(category);
	}
	
	public List<SportsProducts> findAllProductsBySeason(String season) {
		return productRepository.findAllProductsBySeason(season);
	}
	public List<SportsProducts> findAllProductsByColor(String color) {
		return productRepository.findAllProductsByColor(color);
	}
	public List<SportsProducts> findAllProductsByBrand(String brand) {
		return productRepository.findAllProductsByBrand(brand);
	}
	

	
}
