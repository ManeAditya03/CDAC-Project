package com.app.dtos;

import java.time.LocalDate;

public class UpdateUserProfileDto {
	private String fullname;
	private String email;
	private double phone;
	private LocalDate dob;
	public UpdateUserProfileDto(String fullname, String email, double phone, LocalDate dob) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
	}
	public UpdateUserProfileDto() {
		super();
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
}