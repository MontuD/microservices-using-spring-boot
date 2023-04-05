package com.example.webclienttest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import com.example.webclienttest.WebclienttestApplication;
import com.example.webclienttest.service.AppService;

import reactor.core.publisher.Mono;

@RestController
public class AppController {
	
	
		AppService appService;
		Logger logger = LoggerFactory.getLogger(AppController.class);
		
		
		@Autowired
		AppController( AppService appService){
			this.appService = appService;
		}
		
		@GetMapping("/our/test")
		@ResponseBody
		public String getTestResult(){	
			return "Result";
		}

	
	 	@GetMapping("/test")
	    public ResponseEntity makingAwebClientCall() {
	 		return this.appService.getResultFromTestAPI();
	    }
}
