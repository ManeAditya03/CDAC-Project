package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.LoggedInUserDto;
import com.app.dtos.UserRegisterDto;
import com.app.dtos.UserRegisterSuccessDto;
import com.app.pojos.Admin;
import com.app.pojos.Cart;
import com.app.pojos.Course;
import com.app.pojos.Login;
import com.app.pojos.User;
import com.app.repositories.AdminRepository;
import com.app.repositories.CartRepository;
import com.app.repositories.LoginRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AdminRepository adminRepo;

	@Autowired
	private LoginRepository loginRepo;
	
	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	@Override
	public UserRegisterSuccessDto registerUser(UserRegisterDto user) {
		User userEntity = mapper.map(user, User.class);

		Login loginEntity = mapper.map(user, Login.class);
		loginEntity.setUser(userEntity);
		loginEntity.setPassword(encoder.encode(loginEntity.getPassword()));
		
		Cart cartEntity = new Cart();
		cartEntity.setUser(userEntity);

		userEntity.setLogin(loginEntity);
		userEntity.setCart(cartEntity);

		User persistentUser = userRepo.save(userEntity);
		loginRepo.save(loginEntity);
		cartRepo.save(cartEntity);
		return new UserRegisterSuccessDto("User registered successfully with ID " + persistentUser.getId());
	}

	@Override
	public LoggedInUserDto getUserByUsername(String username) {
		Login login = loginRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User Not Found"));
		LoggedInUserDto loggedInUserDto;
		if(username.equals("admin1") || username.equals("admin2")) {
			Admin admin = adminRepo.findByLogin(login).orElseThrow(() -> new RuntimeException("User Not Found"));
			loggedInUserDto = mapper.map(admin, LoggedInUserDto.class);
			loggedInUserDto.setUsername(username);
			loggedInUserDto.setRole("ROLE_ADMIN");	
		}
		else {
			User user =  userRepo.findByLogin(login).orElseThrow(() -> new RuntimeException("User Not Found"));
			loggedInUserDto = mapper.map(user, LoggedInUserDto.class);
			loggedInUserDto.setUsername(username);
			loggedInUserDto.setRole("ROLE_USER");
		}
		return loggedInUserDto;
	}

//	@Override
//	public User updateUserPassword(User updateUserPassword) {
//		User existingUser = userRepo.findById(updateUserPassword.getId()).orElseThrow(() -> new RuntimeException("User Not Found"));
//		
//		User updatedUser = userRepo.save(existingUser);
//		return updatedUser;
//	}

	@Override
	public User updateUserProfile(User updateUserProfile) {
//		if (noteRepo.existsById(detachedNote.getId())) {
//			return noteRepo.save(detachedNote);
//		}
//		throw new ResourceNotFoundException("Invalid Note Id : Updation Failed");
		
		User existingUser = userRepo.findById(updateUserProfile.getId()).orElseThrow(() -> new RuntimeException("User Not Found"));
		existingUser.setFullname(updateUserProfile.getFullname());
		existingUser.setEmail(updateUserProfile.getEmail());
		existingUser.setPhone(updateUserProfile.getPhone());
		existingUser.setDob(updateUserProfile.getDob());
		User updatedUser = userRepo.save(existingUser);
		System.out.println(updatedUser);
		return updatedUser;
	}

	@Override
	public List<Course> getUsersCourses(Long userId) {
		User existingUser = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
		return existingUser.getUserCourses();
	}
}
