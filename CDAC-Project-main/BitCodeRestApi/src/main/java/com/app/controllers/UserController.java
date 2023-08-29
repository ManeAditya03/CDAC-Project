package com.app.controllers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.UpdateUserProfileDto;
import com.app.pojos.Course;
import com.app.pojos.User;
import com.app.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/allUsers")
	public List<User> getAllUsers() {
		System.out.println("in get all emps");
		return userService.getAllUsers();
	}

	@PutMapping("/updateProfile/{userId}")
	public ResponseEntity<?> updateUserProfile(@PathVariable Long userId, @RequestBody @Valid UpdateUserProfileDto updateUserProfile) {
		User detachedUser = mapper.map(updateUserProfile, User.class);
		detachedUser.setId(userId);
		return new ResponseEntity<>(userService.updateUserProfile(detachedUser), HttpStatus.OK);
	}

//	@PutMapping("/updatePassword/{userId}")
//	public ResponseEntity<?> updateUserPassword(@PathVariable Long userId, @RequestBody @Valid UpdateUserProfileDto updateUserPassword) {
//		User detachedUser = mapper.map(updateUserPassword, User.class);
//		return new ResponseEntity<>(userService.updateUserPassword(updateUserPassword), HttpStatus.OK);
//	}
	
	@GetMapping("/userCourses/{userId}")
	public ResponseEntity<?> getUsersCourses(@PathVariable Long userId) {
		return new ResponseEntity<>(userService.getUsersCourses(userId), HttpStatus.OK);
	}
}