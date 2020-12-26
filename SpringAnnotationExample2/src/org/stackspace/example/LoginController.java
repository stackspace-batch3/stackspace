package org.stackspace.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginController {

	@Autowired
	private LoginServicce loginServicce;

	public void login() {
		System.out.println("login()");
		loginServicce.ValidateLoginInfo();
	}
}
