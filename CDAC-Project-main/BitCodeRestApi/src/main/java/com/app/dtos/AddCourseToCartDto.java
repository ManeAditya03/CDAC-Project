package com.app.dtos;

public class AddCourseToCartDto {
	private Long courseId;
	private Long cartId;
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public AddCourseToCartDto(Long courseId, Long cartId) {
		super();
		this.courseId = courseId;
		this.cartId = cartId;
	}
	public AddCourseToCartDto() {
		super();
	}
}
