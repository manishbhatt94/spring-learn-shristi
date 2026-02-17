package com.productapp.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productapp.model.dtos.ApiUserDto;
import com.productapp.model.entities.ApiUser;

@Component
public class UserMapper {

	@Autowired
	private ModelMapper mapper;

	public ApiUserDto convertToDto(ApiUser apiUser) {
		return mapper.map(apiUser, ApiUserDto.class);
	}

	public ApiUser convertToEntity(ApiUserDto apiUserDto) {
		return mapper.map(apiUserDto, ApiUser.class);
	}

}
