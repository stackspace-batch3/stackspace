package org.stackspace.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {

	@GetMapping(value = "check")//http://localhost:9090/check
	public String check() {
		// business logic
		return "Up and Running...";
	}

}
