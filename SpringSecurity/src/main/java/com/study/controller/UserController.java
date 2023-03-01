package com.study.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.model.User;
import com.study.model.dto.UserDTO;
import com.study.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	
	@Autowired
	UserService service;

	@GetMapping(path = {"/"})
	public List<UserDTO> list() throws Exception{
		return service.getList();
	}
	
	@GetMapping(path = { "/{id}" })
	public UserDTO find( @PathVariable("id") UUID id ) throws Exception{
		return service.getReference(id);
	}
	
	@PostMapping(path = {"/"})
	public List<UserDTO> find( @RequestBody User user ) throws Exception{
		return service.getList(user);
	}
	
	@PostMapping(path = {"/save"})
	public UserDTO save( @RequestBody User user ) throws Exception{
		return service.saveOrUpdate(user);
	}
	
	@PutMapping(path = {"/save"})
	public UserDTO update( @RequestBody User user ) throws Exception{
		return service.saveOrUpdate(user);
	}
	
	@DeleteMapping(path = { "/{id}" })
	public void delete( @PathVariable("id") UUID id ) throws Exception{
		service.delete(id);
	}
	
	
	 
	
	
}
