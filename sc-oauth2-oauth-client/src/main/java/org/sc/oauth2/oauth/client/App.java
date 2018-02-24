package org.sc.oauth2.oauth.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	@RequestMapping("/")
	public JsonNode publicProfile(){
		return restTemplate.getForObject("http://localhost:8181/api/me", JsonNode.class);
	}
	
}

