package org.stackspace.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		/*
		 * BeanFactory beanFactory = new XmlBeanFactory(new
		 * ClassPathResource("beans.xml")); LoginService loginService = (LoginService)
		 * beanFactory.getBean("loginService"); System.out.println(loginService);
		 */

		//ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext("org.stackspace.example");
		LoginController loginController = (LoginController) context.getBean("loginController");
		loginController.validate();

	}
}
