package com.app.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class AuthResp {
	private String message;
	private String jwt;
	private Object user;

	public AuthResp(String message, String jwt, Object user) {
		super();
		this.message = message;
		this.jwt = jwt;
		this.user = user;
	}
}