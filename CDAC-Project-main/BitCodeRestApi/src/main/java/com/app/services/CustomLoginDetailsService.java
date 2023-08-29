package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.exception.CustomException;
import com.app.pojos.Login;
import com.app.pojos.User;
import com.app.repositories.LoginRepository;
import com.app.repositories.UserRepository;

@Service
@Transactional

public class CustomLoginDetailsService implements UserDetailsService {
	
	@Autowired
	private LoginRepository loginRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("in load by user nm " + username);
		
		Login login = loginRepo.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid Username"));
		
		System.out.println("lifted user dtls from db "+login);
		return new CustomLoginDetails(login);
	}

}
