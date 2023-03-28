package com.example.libraryadmin.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.libraryadmin.LibraryAdminApplication;
import com.example.libraryadmin.dto.BookDTO;
import com.example.libraryadmin.dto.UserDTO;

import ch.qos.logback.core.joran.spi.NoAutoStart;

@Service
public class LibraryAdminService {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	Logger logger =  LoggerFactory.getLogger(LibraryAdminApplication.class);	
	private  RestTemplate restTemplate;
	private final String HOST = "http://users/api/user/";
	
	
	LibraryAdminService(){
		this.restTemplate = new RestTemplate();
		
	}


	public Optional<UserDTO> createUser(UserDTO user){
		
		ResponseEntity<UserDTO> entity = restTemplate.postForEntity(HOST+"/add", user, UserDTO.class);
		
		System.out.print(entity.getStatusCode());
		
		return Optional.ofNullable(entity.getBody());
	}
	
	
	public Optional<BookDTO> addBookToLibrary(BookDTO book){
		
		ResponseEntity<BookDTO> entity = restTemplate.
				postForEntity("http://bookcatalog/api/book/add",
				book,
				BookDTO.class);
		System.out.print(entity.getStatusCode());
		return Optional.ofNullable(entity.getBody());
	}
	
	
	public Optional<List<UserDTO>> getAllBooks(){
		String url = "http://bookcatalog/api/book/getallbooks";
		
		ResponseEntity<List> entity = restTemplate.getForEntity(url,
				List.class);
		
		
		System.out.print(entity.getStatusCode());
			
		return Optional.ofNullable(entity.getBody());
	}
	
	public Optional<List<BookDTO>> getBooksByAuthor( String author){
		
		ResponseEntity<List> entity = restTemplate.
				getForEntity("http://bookcatalog/api/book/getbooksbyauthor/author={author}",
				List.class,
				author);
		System.out.print(entity.getStatusCode());

		return Optional.ofNullable(entity.getBody());
	}
	
	public Optional<List<BookDTO>> getBooksByBookName(String bookname){
			
			String BASE_URL = "http://bookcatalog/api/book/getbooksbybookname/bookname={bookname}";
			ResponseEntity<List> entity = restTemplate.
					
					getForEntity(BASE_URL,
							List.class,
							bookname);
			System.out.print(entity.getStatusCode());
	
			return Optional.ofNullable(entity.getBody());
		}
	


	public Optional<List<BookDTO>> addBooksToDatabase(List<BookDTO> book){
		ResponseEntity<List> entity = restTemplate.
				postForEntity("http://bookcatalog/api/book/addbooks",
				book,
				List.class);
		logger.info("Data {}",entity.getBody().get(0));
		
		
		System.out.print(entity.getStatusCode());
		return Optional.ofNullable(entity.getBody());
	}

	
}
