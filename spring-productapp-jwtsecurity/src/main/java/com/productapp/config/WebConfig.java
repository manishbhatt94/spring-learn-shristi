package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebConfig {

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	// Bean for Authentication
	@Bean
	AuthenticationManager authenticate(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

	// Bean for Password Encoding
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	// Bean for SecurityFilterChain - For Authorization
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) {
		return httpSecurity
				.csrf((csrf) -> csrf.disable())
				.authorizeHttpRequests(authorize -> {
					authorize
							.requestMatchers("/user-api/v1/**")
							.permitAll()
							.requestMatchers("/product-api/v1/products/**")
							.hasAnyAuthority("ADMIN", "USER")
							.requestMatchers("/product-api/v1/admin/**")
							.hasAuthority("ADMIN")
							.anyRequest()
							.authenticated();
				})
				// handle exception
				.exceptionHandling(configurer -> configurer.authenticationEntryPoint(jwtAuthenticationEntryPoint))
				// handle session
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				// call the filter before this
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}

}
