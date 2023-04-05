package com.example.webclienttest;

import java.lang.ref.Cleaner.Cleanable;

import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.resolver.DefaultAddressResolverGroup;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Controller
@SpringBootApplication
public class WebclienttestApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebclienttestApplication.class, args);
    }
    
    
    
    @Bean
    @Primary
    public WebClient webClient() {
        HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    
    
   
}
