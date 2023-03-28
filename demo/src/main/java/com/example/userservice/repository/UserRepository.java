package com.example.userservice.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.users.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	@Query("select u from User u where u.email = email")
	public Optional<User> ByEmail(String email);

}
