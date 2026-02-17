package com.productapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dtos.JwtUserDto;
import com.productapp.model.entities.JwtUser;
import com.productapp.service.impl.JwtUserServiceImpl;
import com.productapp.util.UserMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class JwtUserController {

	// Auto-wire these using RequiredArgsConstructor
	JwtUserServiceImpl jwtUserService; // Imp: Here we auto-wire the implementation class
	PasswordEncoder encoder;
	UserMapper userMapper;

	@PostMapping("/register")
	ResponseEntity<Void> createUser(@RequestBody JwtUserDto jwtUserDto) {
		// Get the password and encode it
		String password = jwtUserDto.getPassword();
		// Encode password
		String encodedPassword = encoder.encode(password);
		// Set the new password to the userDto object
		jwtUserDto.setPassword(encodedPassword);
		// Use ModelMapper to convert DTO to entity
		JwtUser jwtUser = userMapper.convertToEntity(jwtUserDto);
		// Call the method of service
		jwtUserService.createUser(jwtUser);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
