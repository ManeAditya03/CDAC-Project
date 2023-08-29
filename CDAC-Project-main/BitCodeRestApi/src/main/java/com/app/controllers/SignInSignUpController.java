package com.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.AdminRegisterDto;
import com.app.dtos.AuthRequest;
import com.app.dtos.AuthResp;
import com.app.dtos.LoggedInUserDto;
import com.app.dtos.UserRegisterDto;
import com.app.jwtUtils.JwtUtils;
import com.app.services.AdminService;
import com.app.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/")
public class SignInSignUpController {
	@Autowired
	private JwtUtils utils;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AdminService adminService;

	@PostMapping("signin")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody AuthRequest request) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getUsername(),
				request.getPassword());
		try {
			Authentication authenticatedDetails = manager.authenticate(authToken);
			LoggedInUserDto user = userService.getUserByUsername(request.getUsername());
			return ResponseEntity.ok(new AuthResp("Auth successful!", utils.generateJwtToken(authenticatedDetails), user));
		} catch (BadCredentialsException e) {
			System.out.println("err "+e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
		}

	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody UserRegisterDto user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(user));	
	}
	
	@PostMapping("admin/signup")
	public ResponseEntity<?> userRegistrationAdmin(@RequestBody AdminRegisterDto admin){
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.registerAdmin(admin));	
	}
}