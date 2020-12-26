package org.stackspace.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext("org.stackspace.example");
		
		LoginController loginController = context.getBean(LoginController.class);
		loginController.login();
		
	}
}
