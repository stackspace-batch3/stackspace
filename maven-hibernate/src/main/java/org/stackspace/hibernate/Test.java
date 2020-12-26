package org.stackspace.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;
		try {

			configuration = new Configuration().configure("hibenrate-cfg.xml");

			sessionFactory = configuration.buildSessionFactory();

			session = sessionFactory.openSession();

			Student student1 = new Student(1, 123, "John", "Mech", "Male");
			transaction = session.beginTransaction();
			session.save(student1);

			/*
			 * Student student = new Student(141, "Queen", "CES", "Male");
			 * student.setPkId(2); session.update(student);
			 * 
			 * // System.out.println(pk); Student s1 = (Student) session.get(Student.class,
			 * 1); Student s2 = (Student) session.load(Student.class, 1); //
			 * System.out.println(s1.getName());
			 * 
			 * // student.setPkId(4); session.delete(student);
			 */

			session.flush();
			transaction.commit();

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
}
