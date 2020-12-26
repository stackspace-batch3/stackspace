package org.stackspace.employee.resources;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.stackspace.employee.entity.Employee;
import org.stackspace.employee.exception.DuplicateRecordException;
import org.stackspace.employee.exception.FailedToSaveEmployeeException;
import org.stackspace.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeResourceTest {

	@Mock
	private EmployeeService empService;

	@InjectMocks
	private EmployeeResource empResource;

	@Test
	public void saveTest() throws DuplicateRecordException, FailedToSaveEmployeeException {

		Employee employee = new Employee(0, 1333, "John", "Jogn@stackspace.com", "male", 8.5f, 868554584l, 8.2f, "java",
				"email", "It", new Date(), "true", "", "SA", "abc", "true");

		empResource.save(employee);
	}

	@Test
	public void getAllTest() throws DuplicateRecordException, FailedToSaveEmployeeException {

		assertNull(empResource.getAll());
	}
}
