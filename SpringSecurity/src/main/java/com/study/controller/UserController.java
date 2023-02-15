package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.study.service.UserService;

@Controller(value = "/user")
public class UserController {
	
	@Autowired
	UserService service;

	
	
	
}
