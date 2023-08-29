package com.app.dtos;

import java.time.LocalDate;

public class LoggedInUserDto {
	private String fullname;
	private String username;
	private String email;
	private Long id;
	private double phone;
	private LocalDate dob;
	private String role;
	
	public LoggedInUserDto(String fullname, String username, String email, Long id, double phone, LocalDate dob,
			String role) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.id = id;
		this.phone = phone;
		this.dob = dob;
		this.role = role;
	}
	public LoggedInUserDto() {
		super();
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}