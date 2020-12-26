package org.stackspace.jpa.resource;

import java.io.StringReader;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackspace.jpa.entity.Student;
import org.stackspace.jpa.service.StudentService;
import org.xml.sax.InputSource;

@RestController
@RequestMapping("student")
public class StudentResource {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/getAll")
	public List<Student> getAll() {
		List<Student> students = studentService.getAllStudents();
		return students;
	}

	@GetMapping(value = "/getById/{Id}", produces = { "application/xml", "application/json" })
	public Student getStudentById(@PathVariable("Id") String studentId) {
		int id = Integer.parseInt(studentId);
		Student student = studentService.getStudent(id);
		return student;
	}

	@PostMapping(value = "/save1")
	public Student save(@RequestBody String studentXml) throws JAXBException {

		JAXBContext context = JAXBContext.newInstance(Student.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Student student = (Student) unmarshaller.unmarshal(new InputSource(new StringReader(studentXml)));

		Student stu = studentService.save(student);
		return stu;
	}

	@PostMapping(value = "/save", produces = { "application/xml", "application/json" }, consumes = { "application/xml",
			"application/json" })
	public Student save(@RequestBody Student student) throws JAXBException {

		Student stu = studentService.save(student);
		return stu;
	}

	@PutMapping(value = "/update", consumes = { "application/xml", "application/json" }, produces = { "application/xml",
			"application/json" })
	public Student update(@RequestBody Student student) {

		Student student2 = studentService.update(student);
		return student2;
	}

	// localhost:8989/student/byName/Zoe
	@GetMapping(value = "/byName/{name}")
	public Student getByName(@PathVariable("name") String studentName) {

		Student student = studentService.findByStudentName(studentName);
		return student;
	}

	@GetMapping(value = "/getByLetter/{letter}")
	public List<Student> getByLetterStart(@PathVariable("letter") String letter) {
		List<Student> students = studentService.getByRecordsByLetterStartingWith(letter);
		return students;
	}

	@GetMapping(value = "/getByAge/{age}")
	public List<Student> getByLetterStart(@PathVariable("age") int age) {
		List<Student> students = studentService.getByAgeLessThan(age);
		return students;
	}

	@GetMapping(value = "/getByNameAndAge/{name}/{age}")
	public List<Student> getByLetterStart(@PathVariable("age") int age, @PathVariable("name") String name) {
		List<Student> students = studentService.getByNameAndAge(name, age);
		return students;
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable("id") int studentId) {
		studentService.deleteById(studentId);
	}
}
