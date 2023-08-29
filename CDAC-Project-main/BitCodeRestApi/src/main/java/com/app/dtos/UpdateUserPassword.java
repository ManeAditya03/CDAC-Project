package com.app.dtos;

public class UpdateUserPassword {

	private String username;
	private String password;
	
	public UpdateUserPassword(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
