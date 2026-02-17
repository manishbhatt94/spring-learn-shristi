package com.productapp.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productapp.model.dtos.JwtUserDto;
import com.productapp.model.entities.JwtUser;

@Component
public class UserMapper {

	@Autowired
	private ModelMapper mapper;

	public JwtUserDto convertToDto(JwtUser jwtUser) {
		return mapper.map(jwtUser, JwtUserDto.class);
	}

	public JwtUser convertToEntity(JwtUserDto jwtUserDto) {
		return mapper.map(jwtUserDto, JwtUser.class);
	}

}
