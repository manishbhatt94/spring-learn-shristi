package com.productapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dtos.ApiUserDto;
import com.productapp.model.entities.ApiUser;
import com.productapp.service.impl.ApiUserServiceImpl;
import com.productapp.util.UserMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ApiUserController {

	// Auto-wire these using RequiredArgsConstructor
	ApiUserServiceImpl apiUserService; // Imp: Here we auto-wire the implementation class
	PasswordEncoder encoder;
	UserMapper userMapper;

	@PostMapping("/register")
	ResponseEntity<Void> createUser(@RequestBody ApiUserDto apiUserDto) {
		// Get the password and encode it
		String password = apiUserDto.getPassword();
		// Encode password
		String encodedPassword = encoder.encode(password);
		// Set the new password to the userDto object
		apiUserDto.setPassword(encodedPassword);
		// Use ModelMapper to convert DTO to entity
		ApiUser apiUser = userMapper.convertToEntity(apiUserDto);
		// Call the method of service
		apiUserService.createUser(apiUser);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
