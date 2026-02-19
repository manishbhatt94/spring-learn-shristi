package com.productapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.dtos.JwtUserDto;
import com.productapp.model.entities.JwtUser;
import com.productapp.service.impl.JwtUserServiceImpl;
import com.productapp.util.JwtTokenUtil;
import com.productapp.util.UserMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/user-api/v1")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class JwtUserController {

	// Auto-wire these using RequiredArgsConstructor
	JwtUserServiceImpl jwtUserService; // Imp: Here we auto-wire the implementation class
	PasswordEncoder encoder;
	UserMapper userMapper;
	JwtTokenUtil jwtTokenUtil;

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

	@PostMapping("/login")
	ResponseEntity<String> loginUser(@RequestBody JwtUserDto jwtUserDto) {
		// Get the username from the request
		String username = jwtUserDto.getUsername();
		// Call the method of service - this returns a UserDetails object
		UserDetails userDetails = jwtUserService.loadUserByUsername(username);
		// Call the method of JwtTokenUtil to generate the token
		// The token will have this UserDetails object
		String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(token);
	}

}
