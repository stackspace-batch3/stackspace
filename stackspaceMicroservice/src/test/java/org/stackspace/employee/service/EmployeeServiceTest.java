package org.stackspace.employee.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.stackspace.employee.bindings.Employees;
import org.stackspace.employee.entity.Employee;
import org.stackspace.employee.exception.DuplicateRecordException;
import org.stackspace.employee.exception.FailedToDeleteRecoedException;
import org.stackspace.employee.exception.FailedToSaveEmployeeException;
import org.stackspace.employee.exception.RecordNotFoundException;
import org.stackspace.employee.repository.EmployeeRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepo employeeRepoMock;

	@InjectMocks
	private EmployeeService employeeService;

	@Test
	public void save_InitialEmp_Test() throws DuplicateRecordException, FailedToSaveEmployeeException {

		Employee employee = new Employee();
		employee.setExperience(1.0f);
		when(employeeRepoMock.getMaxEmpId()).thenReturn(null);
		when(employeeRepoMock.save(employee)).thenReturn(employee);

		ResponseEntity<Object> entity = employeeService.save(employee);

		if (entity.getStatusCodeValue() == 201) {
			Employee employee2 = (Employee) entity.getBody();
			assertEquals(1421, employee2.getEmpId());
			assertEquals("Programmer Analyst Trainee", employee2.getDesignation());
		}
	}

	@Test
	public void save_NextEmp_Test() throws DuplicateRecordException, FailedToSaveEmployeeException {

		Employee employee = new Employee();
		employee.setExperience(3.0f);
		when(employeeRepoMock.getMaxEmpId()).thenReturn(1422);
		when(employeeRepoMock.save(employee)).thenReturn(employee);

		ResponseEntity<Object> entity = employeeService.save(employee);

		if (entity.getStatusCodeValue() == 201) {
			Employee employee2 = (Employee) entity.getBody();
			assertEquals(1424, employee2.getEmpId());
			assertEquals("Programmer Analyst", employee2.getDesignation());
		}
	}

	@Test
	public void save_Manager_Test() throws DuplicateRecordException, FailedToSaveEmployeeException {

		Employee employee = new Employee();
		employee.setExperience(11.0f);
		when(employeeRepoMock.getMaxEmpId()).thenReturn(1422);
		when(employeeRepoMock.save(employee)).thenReturn(employee);

		ResponseEntity<Object> entity = employeeService.save(employee);

		if (entity.getStatusCodeValue() == 201) {
			Employee employee2 = (Employee) entity.getBody();

			assertEquals("Manager", employee2.getDesignation());
		}
	}

	@Test
	public void save_SRManager_Test() throws DuplicateRecordException, FailedToSaveEmployeeException {

		Employee employee = new Employee();
		employee.setExperience(16.0f);
		when(employeeRepoMock.save(employee)).thenReturn(employee);

		ResponseEntity<Object> entity = employeeService.save(employee);

		if (entity.getStatusCodeValue() == 201) {
			Employee employee2 = (Employee) entity.getBody();
			assertEquals("Sr. Manager", employee2.getDesignation());
		}

	}

	@Test
	public void save_Ass_DIVE_Test() {

		Employee employee = new Employee();
		employee.setExperience(5.0f);
		when(employeeRepoMock.getMaxEmpId()).thenReturn(1422);
		when(employeeRepoMock.save(employee)).thenThrow(DataIntegrityViolationException.class);

		ResponseEntity<Object> entity = employeeService.save(employee);

		assertEquals(500, entity.getStatusCodeValue());
	}

	@Test
	public void save_SA_Exception_Test() {

		Employee employee = new Employee();
		employee.setExperience(7.0f);

		when(employeeRepoMock.getMaxEmpId()).thenReturn(1422);
		when(employeeRepoMock.save(employee)).thenThrow(ArithmeticException.class);

		ResponseEntity<Object> entity = employeeService.save(employee);

		assertEquals(500, entity.getStatusCodeValue());
	}

	@Test
	public void deleteByEmpIDTest() throws FailedToDeleteRecoedException, RecordNotFoundException {

		when(employeeRepoMock.deleteByEmpId(0)).thenReturn(1);

		employeeService.deleteByEmpID(0);

	}

	@Test
	public void deleteByEmpID_Count_Test() throws FailedToDeleteRecoedException, RecordNotFoundException {

		when(employeeRepoMock.deleteByEmpId(ArgumentMatchers.anyInt())).thenReturn(1);

		ResponseEntity<String> responseEntity = employeeService.deleteByEmpID(0);

		assertEquals(200, responseEntity.getStatusCodeValue());
	}

	@Test
	public void deleteByEmpID_Catch_Test() throws FailedToDeleteRecoedException, RecordNotFoundException {

		when(employeeRepoMock.deleteByEmpId(ArgumentMatchers.anyInt())).thenThrow(NullPointerException.class);

		ResponseEntity<String> responseEntity = employeeService.deleteByEmpID(0);

		assertEquals(500, responseEntity.getStatusCodeValue());

	}

	@Test
	public void getAllEmployeesTest() {

		Employee employee = new Employee(0, 1421, "sri", "sri@gmail.com", "", 0.0f, 885542544l, 0.0f, "Java", "email",
				"It", null, "true", "", "Manager", "", "true");
		when(employeeRepoMock.findAll()).thenReturn(Arrays.asList(employee));

		Employees employees = (Employees) employeeService.getAllEmployees().getBody();
		assertEquals("Manager", employees.getEmployeesList().get(0).getDesignation());

	}

	@Test
	public void getAllEmployees_Catch_Test() {

		when(employeeRepoMock.findAll()).thenThrow(NullPointerException.class);

		ResponseEntity<Object> responseEntity = employeeService.getAllEmployees();
		assertEquals(500, responseEntity.getStatusCodeValue());
	}

	@Test
	public void getByEmpIdTest() {

		Employee employee = new Employee(0, 1421, "sri", "sri@gmail.com", "", 0.0f, 885542544l, 0.0f, "Java", "email",
				"It", null, "true", "", "Manager", "", "true");
		when(employeeRepoMock.findByEmpId(anyInt())).thenReturn(employee);

		Employee emp = (Employee) employeeService.getByEmpId(1421).getBody();
		assertEquals("Manager", emp.getDesignation());

	}

	@Test
	public void getByEmpId_Null_Test() {

		when(employeeRepoMock.findByEmpId(anyInt())).thenReturn(null);

		employeeService.getByEmpId(1421).getBody();

	}

	@Test
	public void getByEmpId_Catch_Test() {

		when(employeeRepoMock.findByEmpId(anyInt())).thenThrow(NullPointerException.class);

		ResponseEntity<Object> responseEntity = employeeService.getByEmpId(1421);
		assertEquals(500, responseEntity.getStatusCodeValue());
	}

	@Test
	public void deleteByEmpID_RecordNotFoundException_Test() throws RecordNotFoundException {

		when(employeeRepoMock.deleteByEmpId(anyInt())).thenReturn(0);

		employeeService.deleteByEmpID(1421).getBody();

	}

	@Test
	public void updateTest() {

		Employee employee = new Employee(0, 1421, "sri", "sri@gmail.com", "", 0.0f, 885542544l, 0.0f, "Java", "email",
				"It", null, "true", "", "Manager", "", "true");
		when(employeeRepoMock.findPkIdByEmpId(anyInt())).thenReturn(employee);

		ResponseEntity<Object> responseEntity = employeeService.update(employee);
		assertEquals(200, responseEntity.getStatusCodeValue());

	}

	@Test
	public void update_Catch_Test() {

		when(employeeRepoMock.findPkIdByEmpId(anyInt())).thenReturn(null);

		ResponseEntity<Object> responseEntity = employeeService.update(null);
		assertEquals(500, responseEntity.getStatusCodeValue());

	}

	@Test
	public void fetchBenchEmpInfoTest() {

		Employee employee = new Employee(0, 1421, "sri", "sri@gmail.com", "", 0.0f, 885542544l, 0.0f, "Java", "email",
				"It", null, "true", "", "Manager", "", "true");
		when(employeeRepoMock.findByisActive(anyString())).thenReturn(Arrays.asList(employee));

		ResponseEntity<Object> responseEntity = employeeService.fetchBenchEmpInfo();
		assertEquals(200, responseEntity.getStatusCodeValue());

	}

	@Test
	public void fetchBenchEmpInfo_Catch_Test() {

		when(employeeRepoMock.findByisActive(anyString())).thenThrow(ArithmeticException.class);

		ResponseEntity<Object> responseEntity = employeeService.fetchBenchEmpInfo();
		assertEquals(500, responseEntity.getStatusCodeValue());

	}

	@Test
	public void getEmpIdsForNonBgvTest() {

		Employee employee = new Employee(0, 1421, "sri", "sri@gmail.com", "", 0.0f, 885542544l, 0.0f, "Java", "email",
				"It", null, "true", "", "Manager", "", "true");
		when(employeeRepoMock.findByIsBgvDone(anyString())).thenReturn(Arrays.asList(employee));

		assertEquals(1421, employeeService.getEmpIdsForNonBgv().get(0));

	}

	@Test
	public void getEmpIdsForNonBgv_Catch_Test() {

		when(employeeRepoMock.findByIsBgvDone(anyString())).thenThrow(ArithmeticException.class);

		List<Integer> list = employeeService.getEmpIdsForNonBgv();
		assertEquals(0, list.size());

	}
}
