package com.app.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dtos.AdminRegisterDto;
import com.app.dtos.UserRegisterSuccessDto;
import com.app.pojos.Admin;
import com.app.pojos.Login;
import com.app.repositories.AdminRepository;
import com.app.repositories.LoginRepository;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public UserRegisterSuccessDto registerAdmin(AdminRegisterDto admin) {
		Admin adminEntity = mapper.map(admin, Admin.class);

		Login loginEntity = mapper.map(admin, Login.class);
		loginEntity.setAdmin(adminEntity);
		loginEntity.setPassword(encoder.encode(loginEntity.getPassword()));
		

		adminEntity.setLogin(loginEntity);

		Admin persistentAdmin = adminRepo.save(adminEntity);
		loginRepo.save(loginEntity);
		return new UserRegisterSuccessDto("User registered successfully with ID " + persistentAdmin.getId());
	}
}
