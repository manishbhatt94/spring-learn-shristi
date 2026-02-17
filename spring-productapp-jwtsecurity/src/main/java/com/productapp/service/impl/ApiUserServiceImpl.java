package com.productapp.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.ApiUser;
import com.productapp.repository.IApiUserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApiUserServiceImpl implements UserDetailsManager {

	IApiUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApiUser apiUser = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid username"));
		// System.out.println("[loadUserByUsername] apiUser: " + apiUser);
		// Create a UserDetails object manually
		UserDetails userDetails = new User(apiUser.getUsername(), apiUser.getPassword(), apiUser.getAuthorities());
		// System.out.println("[loadUserByUsername] userDetails: " + userDetails);
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		// We need ApiUser object. But, what is here in method parameter, is an
		// UserDetails object.
		ApiUser apiUser = (ApiUser) user;
		// Pass the class that is annotated with @Entity
		userRepository.save(apiUser);
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
