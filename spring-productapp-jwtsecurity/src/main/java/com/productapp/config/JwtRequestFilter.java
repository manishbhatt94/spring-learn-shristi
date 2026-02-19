package com.productapp.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.productapp.service.impl.JwtUserServiceImpl;
import com.productapp.util.JwtTokenUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil tokenUtil;

	@Autowired
	private JwtUserServiceImpl jwtUserServiceImpl;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Get the request header
		String header = request.getHeader("Authorization"); // Authorization: Bearer eqwrwqt.12xqsd.asdqwd

		String token = null;
		String username = null;

		// Check if request has header and it is not null and contains Bearer
		if (header != null && header.startsWith("Bearer ")) {
			// get the token value - use substring
			token = header.substring(7);
			// check if token is valid
			// get the name from token
			username = tokenUtil.getUsernameFromToken(token);
		} else {
			logger.warn("Authorization request header absent or malformed	");
		}

		// if username is not null
		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			// check if username is in the database
			UserDetails userDetails = jwtUserServiceImpl.loadUserByUsername(username);
			// validate the token -
			boolean validToken = tokenUtil.validateToken(token, userDetails);
			// if it is valid
			if (validToken) {
				// create an authentication token
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				// set the authentication in the context
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		System.out.println("......I am here...........");

		filterChain.doFilter(request, response);

	}

}
