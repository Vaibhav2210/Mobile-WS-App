package com.vaibhav.mobws.ui.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class updateUserDetailsRequestModel {
	
	@NotNull(message = "FirstName cannot be empty")
	@Size(min=2, message="Firstname must be greater than 2 characters")

	private String firstName;
	
	@NotNull(message = "lastName cannot be empty")
	@Size(min=2, message="Lastname must be greater than 2 characters")

	private String lastName;

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

}
