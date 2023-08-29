package com.app.dtos;

import java.time.LocalDateTime;

public class UserRegisterSuccessDto {
	private String message;
	private LocalDateTime timeStamp;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public UserRegisterSuccessDto() {
		super();
	}

	public UserRegisterSuccessDto(String message) {
		super();
		this.message = message;
		this.timeStamp=LocalDateTime.now();
	}
}
