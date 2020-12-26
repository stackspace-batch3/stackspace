package org.stackspace.bgv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stackspace.bgv.service.BgvService;

@SpringBootApplication
public class StackspaceBgvMicroserviceApplication implements CommandLineRunner {

	@Autowired
	private BgvService bgvService;

	public static void main(String[] args) {
		SpringApplication.run(StackspaceBgvMicroserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// bgvService.getList();

	}

}
