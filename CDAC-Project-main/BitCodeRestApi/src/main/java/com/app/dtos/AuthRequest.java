package com.app.dtos;

import javax.validation.constraints.NotBlank;

public class AuthRequest {
	@NotBlank(message = "Username can't be blank or null")
	private String username;
	@NotBlank(message = "password can't be blank or null")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "AuthRequest [username=" + username + ", password=" + password + "]";
	}
}
