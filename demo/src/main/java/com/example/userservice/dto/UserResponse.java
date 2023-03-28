package com.example.userservice.dto;

import org.springframework.http.HttpStatusCode;

import com.example.userservice.dto.UserResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse{
		String message;
		HttpStatusCode statusCode; 
		UserResponseDTO userResponseDTO;
}
