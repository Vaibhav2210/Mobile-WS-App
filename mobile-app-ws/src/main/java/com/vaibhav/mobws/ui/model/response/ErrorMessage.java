package com.vaibhav.mobws.ui.model.response;

import java.util.Date;

public class ErrorMessage {

	private Date timeStamp;
	private String message;
	
	public ErrorMessage() {}
	
	

	public ErrorMessage(Date date, String localizedMessage) {
		// TODO Auto-generated constructor stub
		this.timeStamp = date;
		this.message = localizedMessage;
	}



	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
