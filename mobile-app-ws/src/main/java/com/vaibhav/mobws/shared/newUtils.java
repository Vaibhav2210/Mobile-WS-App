package com.vaibhav.mobws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class newUtils {
	
	public String generatedUserID() {
		return UUID.randomUUID().toString();
	}

}
