package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "users")
public class User extends BaseEntity {
	final static public String role = "ROLE_USER";
	
	private String fullname;
	private String email;
	private double phone;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private LocalDate dob;
	
	@OneToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	@JsonIgnore
	private Login login;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, 
			fetch = FetchType.EAGER, orphanRemoval = true)
	@JsonIgnore
	private Cart cart;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JsonIgnore
	@JoinTable(
	        name = "User_Course", 
	        joinColumns = { @JoinColumn(name = "userId") }, 
	        inverseJoinColumns = {@JoinColumn(name = "courseId")})
	private List<Course> userCourses = new ArrayList<>();
	
	public void addCourseToUser(List<Course> course) {
		this.userCourses.addAll(course);
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
			fetch=FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	private List<Order> orders = new ArrayList<>();
	
	public void addOrderToUser(Order order) {
		this.orders.add(order);
	}

	public User() {
		super();
	}

	public User(String fullname, String email, double phone, Gender gender, LocalDate dob, Login login, Cart cart,
			List<Course> userCourses, List<Order> orders) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.dob = dob;
		this.login = login;
		this.cart = cart;
		this.userCourses = userCourses;
		this.orders = orders;
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

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Course> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(List<Course> userCourses) {
		this.userCourses = userCourses;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [fullname=" + fullname + ", email=" + email + ", phone=" + phone + ", gender=" + gender + ", dob="
				+ dob + ", login=" + login + ", cart=" + cart + ", userCourses=" + userCourses + ", orders=" + orders
				+ "]";
	}
}