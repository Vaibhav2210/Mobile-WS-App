package com.vaibhav.mobws.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.vaibhav.mobws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class appExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest wr){
		
		String errorMessageDesc = ex.getLocalizedMessage();
		
		if(errorMessageDesc.isEmpty() || errorMessageDesc == null) {
			errorMessageDesc = ex.toString();
		}
		
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDesc);
		
		 
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR
				);
		
	}
	

	
	
	/*@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointException(NullPointerException ex, WebRequest wr){
		
		String errorMessageDesc = ex.getLocalizedMessage();
		
		if(errorMessageDesc.isEmpty() || errorMessageDesc == null) {
			errorMessageDesc = ex.toString();
		}
		
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDesc);
		
		 
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR
				);
		
	}
	
	
	
	@ExceptionHandler(value = {userServiceException.class})
	public ResponseEntity<Object> handleuserServiceExceptionException(userServiceException ex, WebRequest wr){
		
		String errorMessageDesc = ex.getLocalizedMessage();
		
		if(errorMessageDesc.isEmpty() || errorMessageDesc == null) {
			errorMessageDesc = ex.toString();
		}
		
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDesc);
		
		 
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR
				);
		
	}*/
	
	
	
	
	
	@ExceptionHandler(value = {userServiceException.class , NullPointerException.class})
	public ResponseEntity<Object> handleALLException(Exception ex, WebRequest wr){
		
		String errorMessageDesc = ex.getLocalizedMessage();
		
		if(errorMessageDesc.isEmpty() || errorMessageDesc == null) {
			errorMessageDesc = ex.toString();
		}
		
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMessageDesc);
		
		 
		return new ResponseEntity<>(
				errorMessage, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR
				);
		
	}
}
