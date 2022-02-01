package com.ecommerce.sports.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.sports.models.SportsProducts;

import org.springframework.data.domain.Sort;

public interface SportsProductRepository extends CrudRepository<SportsProducts, Integer> {
	Iterable<SportsProducts> findAll(Sort sort);

	public List<SportsProducts> findAllProductsByCategory(String category);

	public List<SportsProducts> findAllProductsBySeason(String season);

	public List<SportsProducts> findAllProductsByColor(String color);

	public List<SportsProducts> findAllProductsByBrand(String brand);
//	public List<Products> findAllProductsByPrice(String priceOrder);
}
