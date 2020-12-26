package org.stackspace.boot.crud.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "student")
public class StudentResource {

	// localhost:8080/student/healthCheck
	@GetMapping(value = "healthCheck")
	public String check() {
		return "Application Up and Runing...";
	}

	// localhost:8080/student/getAll
	@GetMapping("/getAll")
	public String getAllStudents() {
		return "All";
	}

	// localhost:8080/student/getById/123
	@GetMapping(value = "/getById/{string}")
	public String getById(@PathVariable("string") String id) {
		return "Get By Id=" + id;
	}

	// localhost:8080/student/deleteById/123
	@DeleteMapping(value = "/deleteById/{string}")
	public String deleteById(@PathVariable("string") String id) {
		return "Delete By ID=" + id;
	}

	// localhost:8080/student/update/123/Ben
	@PutMapping(value = "/update/{v1}/{v2}")
	public String update(@PathVariable("v1") String id, @PathVariable("v2") String name) {
		return "updated values are " + id + "---" + name;
	}

	// localhost:8080/student/save/abc
	@PostMapping("/save/{value}")
	public String save(@PathVariable("value") String value) {
		return value;
	}

	// localhost:8080/student/save
	@PostMapping("/save")
	public String saveInfo(@RequestBody String value) {
		return value;
	}
}
