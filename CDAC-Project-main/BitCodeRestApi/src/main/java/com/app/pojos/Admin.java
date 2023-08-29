package com.app.pojos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "admins")
public class Admin extends BaseEntity {
	
	final static public String role = "ROLE_ADMIN";
	
	private String fullname;
	private String email;
	
	@OneToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private Login login;

	public Admin(String fullname, String email, Login login) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.login = login;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public static String getRole() {
		return role;
	}

	public Admin() {
		super();
	}
}