package com.vaibhav.mobws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class Utils {
	
	
	@PostConstruct
	public String generateUserID() {
		return UUID.randomUUID().toString();
	}

}
