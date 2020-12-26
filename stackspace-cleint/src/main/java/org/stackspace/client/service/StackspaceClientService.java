package org.stackspace.client.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.stackspace.client.model.Employee;

@Service
public class StackspaceClientService {

	private static final String BASE_URL = "http://localhost:7071/stackspace/employee";
	@Autowired
	private RestTemplate restTemplate;

	public void getAll() {

		try {

			String body = restTemplate.getForEntity(BASE_URL, String.class).getBody();
			System.out.println(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getById() {

		try {

			String body = restTemplate.getForEntity("BASE_URL/" + 1423, String.class).getBody();
			System.out.println(body);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {

			Employee employee = new Employee("Sri", "Sri.stackspce.com", "nale", 7.8f, 55685258l, 7.5f, "java",
					"mobile", "IT", new Date(), "true", "", "abc", "");

			ResponseEntity<Employee> response = restTemplate.postForEntity(BASE_URL, employee, Employee.class);

			if (response.getStatusCode().is2xxSuccessful()) {
				System.out.println(response.getBody());
			} else {
				System.out.println("Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void update() {
		try {

			Employee employee = new Employee("Sri", "Sri.stackspce.com", "male", 7.8f, 55685258l, 7.5f, "java",
					"mobile", "IT", new Date(), "true", "", "abc", "");
			employee.setEmpId(1437);
			employee.setPkId(10);
			employee.setDesignation("Sr. Associat");

			restTemplate.put(BASE_URL, employee);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteById() {

		try {
			restTemplate.delete("BASE_URL/" + 1437);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
