package org.statckspace.springmessagebeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringBeanTest {
	public static void main(String[] args) {

		/*BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("beans.xml"));
		MessageFormatter formatter = (MessageFormatter) beanFactory.getBean("target");
		formatter.write();
		formatter.print();*/
		
		//FileSystemXmlApplicationContext()
		//ClassPathXmlApplicationContext()
		//AnnotationConfigApplicationContext()
		ApplicationContext context= new FileSystemXmlApplicationContext("F:\\batch-3\\projects\\springMessageBeans\\src\\beans.xml");
		MessageFormatter formatter =(MessageFormatter) context.getBean("target");
		formatter.write();
		formatter.print();
	}
}
