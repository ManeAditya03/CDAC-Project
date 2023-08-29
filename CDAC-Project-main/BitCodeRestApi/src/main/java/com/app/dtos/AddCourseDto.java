package com.app.dtos;

public class AddCourseDto {
	private String courseName;
	private String author;
	private double price;
	private int duration;
	private String description;
	private String imagePath;
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
	public AddCourseDto(String courseName, String author, double price, int duration, String description,
			String imagePath) {
		super();
		this.courseName = courseName;
		this.author = author;
		this.price = price;
		this.duration = duration;
		this.description = description;
		this.imagePath = imagePath;
	}
	public AddCourseDto() {
		super();
	}
}
