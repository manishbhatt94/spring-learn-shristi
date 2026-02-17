package com.productapp.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productapp.model.entities.JwtUser;
import com.productapp.repository.IJwtUserRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtUserServiceImpl implements UserDetailsManager {

	IJwtUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUser jwtUser = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Invalid username"));
		// System.out.println("[loadUserByUsername] jwtUser: " + jwtUser);
		// Create a UserDetails object manually
		UserDetails userDetails = new User(jwtUser.getUsername(), jwtUser.getPassword(), jwtUser.getAuthorities());
		// System.out.println("[loadUserByUsername] userDetails: " + userDetails);
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		// We need ApiUser object. But, what is here in method parameter, is an
		// UserDetails object.
		JwtUser jwtUser = (JwtUser) user;
		// Pass the class that is annotated with @Entity
		userRepository.save(jwtUser);
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
