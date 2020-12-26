package org.stackspace.employee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.stackspace.employee.entity.PreviousExperienceInfo;
import org.stackspace.employee.repository.PreviousCompaniesRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PreviousCompaniesServiceTest {

	@Mock
	private EmployeeService employeeService;

	@Mock
	private PreviousCompaniesRepo companiesRepo;

	@InjectMocks
	private PreviousCompaniesService companiesService;

	@Test
	public void getAllTest() {

		PreviousExperienceInfo info = new PreviousExperienceInfo();
		info.setEmpId("IBM-123");
		info.setStackspaceEmpId(1421);

		PreviousExperienceInfo info1 = new PreviousExperienceInfo();
		info1.setEmpId("Google-123");
		info1.setStackspaceEmpId(1421);

		when(employeeService.getEmpIdsForNonBgv()).thenReturn(Arrays.asList(1421, 1422));
		when(companiesRepo.findByStackspaceEmpId(1421)).thenReturn(Arrays.asList(info, info1));
		assertEquals(200, companiesService.getAll().getStatusCodeValue());
	}

	@Test
	public void getAll_Catch_Test() {

		when(employeeService.getEmpIdsForNonBgv()).thenThrow(ArithmeticException.class);
		assertEquals(500, companiesService.getAll().getStatusCodeValue());
	}
}
