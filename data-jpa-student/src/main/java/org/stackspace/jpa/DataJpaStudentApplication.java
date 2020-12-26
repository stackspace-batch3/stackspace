package org.stackspace.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.stackspace.jpa.entity.Student;
import org.stackspace.jpa.repository.StudentRepo;

@SpringBootApplication
public class DataJpaStudentApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaStudentApplication.class, args);
	}

	@Autowired
	private StudentRepo repo;

	@Override
	public void run(String... args) throws Exception {
//		Student student = repo.getByStudentName("Zoe");
		 List<Student> student=repo.findByStudentIdNative(new Integer(254));
		System.out.println(student);
	}

}
