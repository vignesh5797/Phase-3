package com.ecommerce.sports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.sports.models.Administrator;
import com.ecommerce.sports.service.SportsAdministratorService;

@RestController
public class AdministratorController {

	@Autowired
	private SportsAdministratorService service;
	
	@GetMapping("/Admins")
	public List<Administrator> findAllAdmins()
	{
		return service.getAdmins();
	}
	
	@PutMapping("/UpdateAdmin")
	public Administrator updateAdmin(@RequestBody Administrator admin)
	{
		return service.updateAdmin(admin);
	}
}
