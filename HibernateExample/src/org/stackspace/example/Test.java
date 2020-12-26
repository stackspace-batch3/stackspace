package org.stackspace.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		try {

			configuration = new Configuration().configure("hibenrate-cfg.xml");

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			// Student student = new Student(1, 123, "John", "Mech", "Male");
			transaction = session.beginTransaction();
			Student student = new Student(142, "Zoe", "ECE", "Male");
			//int pk = (int) session.save(student);
			//Student s1 = (Student) session.get(Student.class,1 );
//			Student s1 = (Student) session.load(Student.class,1 );
//			System.out.println(s1.getName());
			
			student.setPkId(4);
			session.delete(student);
			transaction.commit();
			
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
