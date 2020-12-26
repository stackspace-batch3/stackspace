package org.stackspace.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class LoginController {

	@Autowired
	private LoginService loginService;

	public LoginController() {
		System.out.println("--------");
	}

	public void validate() {

		loginService.validateUser();
	}

}
