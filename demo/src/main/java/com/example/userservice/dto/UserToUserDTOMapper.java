package com.example.userservice.dto;

import java.util.function.Function;

import com.example.userservice.users.User;



public class UserToUserDTOMapper implements Function<User,UserResponseDTO>{
	
	

	@Override
	public UserResponseDTO apply(User user) {
		UserResponseDTO userResponseDTO  = new UserResponseDTO(
				user.getFullname(),
				user.getEmail(),
				user.getId());
		
		return userResponseDTO;
	}

}
