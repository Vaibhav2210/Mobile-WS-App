package com.vaibhav.mobws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaibhav.mobws.shared.newUtils;
import com.vaibhav.mobws.ui.model.request.userDetailsRequestModel;
import com.vaibhav.mobws.ui.model.response.userRest;
import com.vaibhav.mobws.userservice.userService;


@Service
public class userServiceImpl implements userService{
	
	Map<String, userRest> users;
	
	//Utils newUtils;
	
	newUtils NU;
	
	public userServiceImpl() {}

	
	@Autowired
	public userServiceImpl(newUtils utils) {
		this.NU = utils;
		
	}

	@Override
	public userRest createUser(userDetailsRequestModel userDetails) {
		userRest returnValue = new userRest();
		//returnValue.setEmailID(userDetails.getEmail());
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());
		returnValue.setEmailID(userDetails.getEmailID());
		
		//String userID = UUID.randomUUID().toString();  // Generated Random character string via line code
		
		//String userID = utils.generateUserId();		//Generates random characters via Dependencies injection via constructor
		
		String UserID = NU.generatedUserID();
		returnValue.setUserID(UserID); 
		//returnValue.setUserID(utils.generateUserID(1));
		
		if(users == null) users = new HashMap<>();
		users.put(UserID, returnValue);
		
		return returnValue;
	}

}
