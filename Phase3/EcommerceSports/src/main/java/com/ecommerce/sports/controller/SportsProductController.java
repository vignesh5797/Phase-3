package com.ecommerce.sports.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sports.models.SportsProducts;
import com.ecommerce.sports.repository.SportsProductRepository;
import com.ecommerce.sports.service.SportsProductService;

@RestController
@RequestMapping(path = "/ecommerce")
public class SportsProductController {

	@Autowired
	private SportsProductRepository productRepository;

	@Autowired
	private SportsProductService productService;

	@PostMapping(path = "/addProduct")
	public @ResponseBody String addProduct(@RequestBody SportsProducts product) {
		productRepository.save(product);
		return "Added the product data successfully";
	}

	@GetMapping("getProductById/{productId}")
	public Optional<SportsProducts> getbookId(@PathVariable int productId) {
		return productRepository.findById(productId);
	}

	@GetMapping("getAllProducts")
	public List<SportsProducts> getAllProducts() {
		List<SportsProducts> product = (List<SportsProducts>) productRepository.findAll();
		return product;
	}

	@GetMapping("getProductByCategory/{category}")
	public List<SportsProducts> getProductByCategory(@PathVariable String category) {
		List<SportsProducts> product = (List<SportsProducts>) productService.findAllProductsByCategory(category);
		return (List<SportsProducts>) product;
	}

	@GetMapping("getProductBySeason/{season}")
	public List<SportsProducts> getProductBySeason(@PathVariable String season) {
		List<SportsProducts> product = (List<SportsProducts>) productService.findAllProductsBySeason(season);
		return (List<SportsProducts>) product;
	}

	@GetMapping("getProductByColor/{color}")
	public List<SportsProducts> getProductByColor(@PathVariable String color) {
		List<SportsProducts> product = (List<SportsProducts>) productService.findAllProductsByColor(color);
		return (List<SportsProducts>) product;
	}

	@GetMapping("getProductByBrand/{brand}")
	public List<SportsProducts> getProductByBrand(@PathVariable String brand) {
		List<SportsProducts> product = (List<SportsProducts>) productService.findAllProductsByBrand(brand);
		return (List<SportsProducts>) product;
	}

	@GetMapping("getProductByPrice/{priceOrder}")
	public List<SportsProducts> getProductByPrice(@PathVariable String priceOrder) {
		List<SportsProducts> product;
		if (priceOrder.equals("asc")) {
			product = (List<SportsProducts>) productRepository.findAll(Sort.by("price"));
		} else {
			product = (List<SportsProducts>) productRepository.findAll(Sort.by("price").descending());
		}

		return  product;
	}
	@GetMapping("getProductByDate/{dateOrder}")
	public List<SportsProducts> getProductByDate(@PathVariable String dateOrder) {
		List<SportsProducts> product;
		if (dateOrder.equals("asc")) {
			product = (List<SportsProducts>) productRepository.findAll(Sort.by("createdDate"));
		} else {
			product = (List<SportsProducts>) productRepository.findAll(Sort.by("createdDate").descending());
		}

		return product;
	}


	@PutMapping("updateProductById/{productId}")
	public SportsProducts updateProductById(@PathVariable int productId, @RequestBody SportsProducts newProduct) {
		return productService.updateProductById(productId, newProduct);
	}

	@DeleteMapping("deleteProductById/{productId}")
	public String deleteAProductById(@PathVariable int productId) {
		productRepository.deleteById(productId);
		return "Deleted the product with ID : " + productId;
	}

	@DeleteMapping("deleteAllProducts")
	public String deleteAppProducts() {
		productRepository.deleteAll();
		return "Deleted all the products";
	}

	// Search?
}
