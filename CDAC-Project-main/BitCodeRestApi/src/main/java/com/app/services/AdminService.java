package com.app.services;

import com.app.dtos.AdminRegisterDto;
import com.app.dtos.UserRegisterSuccessDto;

public interface AdminService {
	UserRegisterSuccessDto registerAdmin(AdminRegisterDto admin);
}