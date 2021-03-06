package com.ecommerce.sports.controller;

import java.util.List;
import java.util.Optional;

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
import com.ecommerce.sports.models.SportsUser;
import com.ecommerce.sports.repository.SportsUserRepository;
import com.ecommerce.sports.service.SportsUserService;


@RestController
@RequestMapping(path = "/sports")
public class SportsUserController {

	@Autowired
	private SportsUserRepository userRepository;
	
//	@Autowired
//	private UserService userService;
	
	@PostMapping(path = "/addUser")
	public @ResponseBody String addProduct(@RequestBody SportsUser user) {
		System.out.println("Inside Add User ------------------------------" + user.getUserId());
		userRepository.save(user);
		return "User details has been added successfully";
	} 
	
	@GetMapping("getUserById/{userId}")
	public Optional<SportsUser> getbookId(@PathVariable int userId)
	{
		System.out.println("Inside Get product by id ------------------------------" + userId);
	
		return userRepository.findById(userId);
	}
	
 
	
	@GetMapping("getAllUsers")
	public List<SportsUser> getAllUsers()
	{
		List<SportsUser> user=(List<SportsUser>) userRepository.findAll();
		return user;
	}
	
	@DeleteMapping("deleteUserById/{userId}")
	public String deleteUserById(@PathVariable int userId) {
		userRepository.deleteById(userId);
		return "Deleted the user with ID : "+ userId;
	}
	
	@DeleteMapping("deleteAllUsers")
	public String deleteAllUsers() {
		userRepository.deleteAll();
		return "Deleted all the users";
	}
}
