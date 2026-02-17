package com.productapp.model.dtos;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class JwtUserDto {

	@EqualsAndHashCode.Include
	private Integer jwtuserId;

	private String username;

	private String password;

	private Set<String> roles;

}
