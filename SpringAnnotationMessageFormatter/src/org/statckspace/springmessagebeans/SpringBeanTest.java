package org.statckspace.springmessagebeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringBeanTest {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.statckspace.springmessagebeans");

		MessageFormatter formatter = (MessageFormatter) applicationContext.getBean(PdfFormatter.class);

		formatter.write();
		formatter.print();
	}
}
