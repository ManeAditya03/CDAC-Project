package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "courses")
public class Course extends BaseEntity {
	private String courseName;
	private String author;
	private double price;
	private int duration;
	private String description;
	private String imagePath;
	
	@ManyToMany(mappedBy = "userCourses")
	@JsonIgnore
	private List<User> users = new ArrayList<>();
	
	@ManyToMany(mappedBy = "cartCourses")
	@JsonIgnore
	private List<Cart> cart = new ArrayList<>();
	
	@ManyToMany(mappedBy = "orderCourses")
	@JsonIgnore
	private List<Order> order = new ArrayList<>();
	
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL,
			fetch=FetchType.LAZY, orphanRemoval = true)
	@JsonIgnore
	private List<CourseDetails> courseDetails = new ArrayList<>();
	
	public int countOfUsers() {
		return users.size();
	}
	
	public Course(String courseName, String author, double price, int duration, String description, String imagePath,
			List<User> users, List<Cart> cart, List<Order> order, List<CourseDetails> courseDetails) {
		super();
		this.courseName = courseName;
		this.author = author;
		this.price = price;
		this.duration = duration;
		this.description = description;
		this.imagePath = imagePath;
		this.users = users;
		this.cart = cart;
		this.order = order;
		this.courseDetails = courseDetails;
	}

	public Course() {
		super();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public List<CourseDetails> getCourseDetails() {
		return courseDetails;
	}

	public void setCourseDetails(List<CourseDetails> courseDetails) {
		this.courseDetails = courseDetails;
	}
}