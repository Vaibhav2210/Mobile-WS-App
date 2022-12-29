package com.vaibhav.mobws.userservice;

import com.vaibhav.mobws.ui.model.request.userDetailsRequestModel;
import com.vaibhav.mobws.ui.model.response.userRest;

public interface userService {
	
	userRest createUser(userDetailsRequestModel userDetails);

}
