package com.stackroute.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.project.Application;
import com.stackroute.project.domains.User;
import com.stackroute.project.services.UserService;


@RestController
@RequestMapping(value="/goplaces")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping(value="/uservalidation",consumes= {"application/json"})
	public ResponseEntity<String> userValidation(@RequestBody User user){
		Boolean b=userservice.check(user);
		if(b) {
		return new ResponseEntity<String>("valid user",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not valid user",HttpStatus.OK);
		
	}
	
	@PostMapping(value="/signup")
	public ResponseEntity<String> signUp(@RequestBody User user){
		Boolean b=userservice.add(user);
		if(b) {
		return new ResponseEntity<String>("You have signed in",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Not valid user",HttpStatus.OK);
	}
}
