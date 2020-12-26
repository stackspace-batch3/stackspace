package org.stackspace.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.stackspace.client.service.StackspaceClientService;

@SpringBootApplication
public class StackspaceCleintApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StackspaceCleintApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	private StackspaceClientService service;

	@Override
	public void run(String... args) throws Exception {

		
		//service.getAll();
		//service.save();
		//service.update();
		//service.deleteById();
		service.getById();
	}

}
