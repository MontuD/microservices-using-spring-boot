package com.example.webclienttest.service;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.webclienttest.Product;

@Service
public class AppService {
	
	WebClient client;
	

	@Autowired
	public AppService(WebClient client) {
		super();
		this.client = client;
	}


	public ResponseEntity getResultFromTestAPI(){
		Logger logger = LoggerFactory.getLogger(AppService.class);
		
		 try {
			 logger.info("HIT REQUEST");
			 return ResponseEntity.ok(
					 client
					 .get()
					 .uri("http://localhost:8085/api/admin/test")
					 .retrieve()
					 .bodyToMono(String.class)
				);
		}
		 catch(Exception exception) {
			 exception.printStackTrace();
		 }
		return  ResponseEntity.badRequest().body("Nothing");
			
	}
	
}
