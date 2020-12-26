package org.stackspace.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		/*
		 * Employee employee = new Employee(); employee.setEmpId(1422);
		 * employee.setName("Ben"); employee.setSkills("Spring");
		 */

		/*
		 * int pk = (int) session.save(employee); System.out.println(pk);
		 */

		Employee employee = (Employee) session.get(Employee.class, 1);
		System.out.println(employee);

		transaction.commit();
	}
}
