package org.stackspace.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("org.stackspace.springcore");
		
		PdfFormatter pdfFormatter = applicationContext.getBean(PdfFormatter.class);
		pdfFormatter.write();
		pdfFormatter.print();
	}
}
