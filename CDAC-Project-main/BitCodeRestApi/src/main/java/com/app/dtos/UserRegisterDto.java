package com.app.dtos;

import java.time.LocalDate;

import com.app.pojos.Gender;

public class UserRegisterDto {
	private String fullname;
	private String email;
	private double phone;
	private Gender gender;
	private LocalDate dob;
	private String username;
	private String password;
	
	public UserRegisterDto(String fullname, String email, double phone, Gender gender, LocalDate dob, String username,
			String password) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.username = username;
		this.password = password;
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

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
}