package com.ecommerce.sports.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.sports.models.SportsProductOrder;
import com.ecommerce.sports.models.SportsProducts;

public interface SportsProductOrderRepository extends CrudRepository<SportsProducts, Integer> {
}
