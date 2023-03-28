package com.example.userservice.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor

public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	String fullname;
	String email;
	String password;
	
	public User() {}
	
	public User(String fullname,String email,String password) {
		this.email = email;
		this.fullname = fullname;
		this.password = password;
	}
	
	
}
