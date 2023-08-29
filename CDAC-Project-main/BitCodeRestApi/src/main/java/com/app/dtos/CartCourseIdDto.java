package com.app.dtos;

public class CartCourseIdDto {
	private Long cartId;
	private Long courseId;
	
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public CartCourseIdDto(Long cartId, Long courseId) {
		super();
		this.cartId = cartId;
		this.courseId = courseId;
	}
	public CartCourseIdDto() {
		super();
	}
	@Override
	public String toString() {
		return "CartCourseIdDto [cartId=" + cartId + ", courseId=" + courseId + "]";
	}
	
}
