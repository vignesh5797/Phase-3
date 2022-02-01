package com.ecommerce.sports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.sports.models.Administrator;
import com.ecommerce.sports.repository.SportsAdministratorRepository;

@Service
public class SportsAdministratorService {

	@Autowired
	private SportsAdministratorRepository repository;
	
	//get methods
		public List<Administrator> getAdmins()
		{
			return (List<Administrator>) repository.findAll();
		}
		
	public Administrator updateAdmin(Administrator admin)
	{ 
		Administrator existingAdmin = repository.findById(admin.getAdminId()).orElse(null);
		existingAdmin.setAdminId(admin.getAdminId());
		existingAdmin.setPass(admin.getPass());
		return repository.save(existingAdmin);
	}
	
}
