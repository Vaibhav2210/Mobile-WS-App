package com.vaibhav.mobws.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class userDetailsRequestModel {

	@NotNull(message = "FirstName cannot be empty")
	private String firstName;
	
	@NotNull(message = "lastName cannot be empty")
	private String lastName;
	
	//@NotNull(message = "email cannot be empty")
	private String email;
	
	@NotNull(message = "emailID cannot be empty")
	@Email
	private String emailID;
	
	@NotNull(message = "password cannot be empty") 
	@Size(min=8,message="Password must be equal or greater than 8 characters")
	private String password;

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
