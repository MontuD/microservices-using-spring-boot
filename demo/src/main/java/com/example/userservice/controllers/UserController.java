package com.example.userservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dto.UserDTO;
import com.example.userservice.dto.UserResponse;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.users.User;
import com.example.userservice.userservice.UserService;
import com.fasterxml.jackson.core.JsonFactory;


@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/test")
	public String Hello() {
		return "Hello World";
	}

	@PostMapping("/add")
	@ResponseBody
	public ResponseEntity<User> saveUser(@RequestBody UserDTO userDTO) {
		User userEntity = this.userService.addUser(userDTO);	
		return ResponseEntity.ok().body(userEntity);
	}

	@GetMapping("/alluser")
	@ResponseBody
	public ResponseEntity<List<UserResponseDTO>> allUser() {
		List<UserResponseDTO> users = this.userService.getAllUser();
		return ResponseEntity.ok().body(users);
	}
	
	
	@PostMapping("/getuserbyemail")
	@ResponseBody
	public ResponseEntity getUserByEmail(@RequestBody String email) {
		System.out.print(email);
		Optional<UserResponseDTO> user = Optional.ofNullable(this.userService.ByEmail(email));
		if(user.isPresent()) {
			 return ResponseEntity.ok().body(user.get());
		}
		
		return new ResponseEntity( new UserResponse("User Not Found",
				HttpStatusCode.valueOf(404),
				null), HttpStatusCode.valueOf(404));
		}
	
}
