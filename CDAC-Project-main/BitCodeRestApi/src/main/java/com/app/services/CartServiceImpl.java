package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.AddCourseToCartDto;
import com.app.dtos.CartCourseIdDto;
import com.app.pojos.Cart;
import com.app.pojos.Course;
import com.app.pojos.User;
import com.app.repositories.CartRepository;
import com.app.repositories.CourseRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CourseRepository courseRepo;

	@Autowired
	private ModelMapper mapper;

	@Override
	public String addCourseToCart(AddCourseToCartDto courseToCartDto) {
		Cart cart = cartRepo.findById(courseToCartDto.getCartId()).orElseThrow(() -> new RuntimeException("Cart not found"));
		Course course = courseRepo.findById(courseToCartDto.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
		if(cart.addCourseToCart(course)) {
			cart.setNoItems(cart.getNoItems()+1);
			cart.setCartTotal(cart.getCartTotal()+course.getPrice());
			cartRepo.save(cart);
			return "Course Added to Cart Successfully.";
		}
		return "Course Already Exist in Cart or Purchased";
	}

	@Override
	public List<Course> getCourseInCartByUserId(Long userid) {
		User user = userRepo.findById(userid).orElseThrow(() -> new RuntimeException("User not found"));
		List<Course> courses = user.getCart().getCartCourses();
		return courses;
	}

	@Override
	public Long getCartTotalByUserId(Long userid) {
		User user = userRepo.findById(userid).orElseThrow(() -> new RuntimeException("User not found"));
		Long cartTotal = (long) user.getCart().getCartTotal();
		return cartTotal;
	}

	@Override
	public String dropItemFromCart(CartCourseIdDto cartCourseIdDto) {
		System.out.println(cartCourseIdDto);
		Cart cart = cartRepo.findById(cartCourseIdDto.getCartId()).orElseThrow(() -> new RuntimeException("Cart not found"));
		Course course = courseRepo.findById(cartCourseIdDto.getCourseId()).orElseThrow(() -> new RuntimeException("Course not found"));
		cart.removeCourseFromCart(course);
		cart.setCartTotal(cart.getCartTotal()-course.getPrice());
		cart.setNoItems(cart.getNoItems()-1);
		
		return "Course removed from cart successfully.";
	}	
}