package org.stackspace.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.stackspace.jpa.entity.Student;
import org.stackspace.jpa.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepo.findAll();
		// from Student
		return studentList;
	}

	public Student getStudent(int studentId) {
		Student student = studentRepo.findByStudentID(studentId);
		// from Student where Pk=1451
		return student;
	}

	public Student save(Student student) {
		Student stu = studentRepo.save(student);
		return stu;
	}

	public Student update(Student student) {

		Student student2 = studentRepo.save(student);
		return student2;
	}

	public Student findByStudentName(String studentName) {
		String name = studentName.toLowerCase();
		Student student = studentRepo.findByStudentName(name);
		return student;
	}

	public List<Student> getByRecordsByLetterStartingWith(String letter) {
		List<Student> list = studentRepo.findByStudentNameStartingWith(letter);

		return list;
	}

	public List<Student> getByAgeLessThan(int age) {
		List<Student> list = studentRepo.findByAgeLessThan(age);

		return list;
	}

	public List<Student> getByNameAndAge(String name, int age) {
		List<Student> list = studentRepo.findByStudentNameAndAge(name, age);
		return list;
	}

	public void deleteById(int studentId) {
		studentRepo.deleteById(studentId);

	}
}
