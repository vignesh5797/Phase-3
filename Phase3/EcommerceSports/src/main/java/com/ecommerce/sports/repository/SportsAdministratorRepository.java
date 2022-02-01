package com.ecommerce.sports.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.sports.models.Administrator;



public interface SportsAdministratorRepository extends CrudRepository<Administrator, String> {

	
}
