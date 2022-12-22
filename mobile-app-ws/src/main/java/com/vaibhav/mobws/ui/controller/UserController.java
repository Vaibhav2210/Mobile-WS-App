package com.vaibhav.mobws.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.mobws.ui.model.request.userDetailsRequestModel;
import com.vaibhav.mobws.ui.model.response.userRest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")   //Open up http://localhost:8080/users
public class UserController {
	
	
	Map<String, userRest> users;
	
	@GetMapping
	public String getUser(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit",defaultValue="100") int limit ) {
		return "Get User was called with page = "+ page + " and limit = "+ limit;
	}
	
	@GetMapping(path="/{userID}", produces = { MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE
			})
	public ResponseEntity<userRest> getUser(@PathVariable String userID) {
		
		/*userRest returnValue = new userRest();
		returnValue.setEmailID("vaibhavsarode10@gamil.com");
		returnValue.setFirstName("Vaibhav");
		returnValue.setLastName("Sarode");
		return new ResponseEntity<userRest>(returnValue,HttpStatus.OK);*/
		
		
		if(users.containsKey(userID)) {
			return new ResponseEntity<>(users.get(userID),HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping(path="/")
	public String getAllUSers() {
		return "Get AlUser was called with page";
	}
	
	
	
	
	
	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, 
			MediaType.APPLICATION_XML_VALUE
			}, 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
					MediaType.APPLICATION_XML_VALUE
					})
	public ResponseEntity<userRest> createUser(
			@Valid
			@RequestBody 
			userDetailsRequestModel userDetails) {
		
		userRest returnValue = new userRest();
		//returnValue.setEmailID(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmailID(userDetails.getEmailID());
		
		String userID = UUID.randomUUID().toString();
		returnValue.setUserID(userID);
		
		if(users == null) users = new HashMap<>();
		users.put(userID, returnValue);
		
		
		//returnValue.setUserID(userDetails.getPassword());
		return new ResponseEntity<userRest>(returnValue,HttpStatus.OK);
		


	}
	
	
	
	@PutMapping
	public String updateUser() {
		return "Update User was called";
	}
	
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete User was called";
	}
}
