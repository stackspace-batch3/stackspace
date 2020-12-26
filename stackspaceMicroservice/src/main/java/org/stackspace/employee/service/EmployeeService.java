package org.stackspace.employee.service;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.stackspace.employee.bindings.BenchEmpInfoList;
import org.stackspace.employee.bindings.Employees;
import org.stackspace.employee.entity.Employee;
import org.stackspace.employee.exception.RecordNotFoundException;
import org.stackspace.employee.model.BenchEmployeeInfo;
import org.stackspace.employee.repository.EmployeeRepo;

@Repository
public class EmployeeService {

	private static int initialEmpID = 1421;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepo employeeRepo;

	public ResponseEntity<Object> save(Employee employee) {

		int nextEmpId = 0;
		float experience = 0.0f;

		String designation = null;
		String errorMessage = null;

		Employee emp = null;
		Integer maxEmpId = 0;
		ResponseEntity<Object> responseEntity = null;
		try {
			LOGGER.info("start of save(...)");
			maxEmpId = employeeRepo.getMaxEmpId(); // 1421, 1423

			if (ObjectUtils.isEmpty(maxEmpId)) {
				// For first user
				LOGGER.info("This is first user. So empId= {}", initialEmpID);
				employee.setEmpId(initialEmpID);
			} else {
				nextEmpId = maxEmpId + 2;
				LOGGER.info(" empId= {}", nextEmpId);
				employee.setEmpId(nextEmpId);
			}

			experience = employee.getExperience();

			LOGGER.info("Employee experience= {}", experience);
			if (experience <= 2.0) {
				designation = "Programmer Analyst Trainee";
			} else if (experience > 2.0 && experience < 4.0) {
				designation = "Programmer Analyst";
			} else if (experience > 4.0 && experience < 6.0) {
				designation = "Assosiate";
			} else if (experience > 6.0 && experience < 10.0) {
				designation = "Senior Assosiate";
			} else if (experience > 10.0 && experience < 13.0) {
				designation = "Manager";
			} else {
				designation = "Sr. Manager";
			}

			employee.setDesignation(designation);

			emp = employeeRepo.save(employee);

			responseEntity = new ResponseEntity<>(emp, HttpStatus.CREATED);
		} catch (DataIntegrityViolationException e) {

			LOGGER.error("Error while saving the employee due to duplicate column{}", e);
			errorMessage = "Duplication column insertion {}";
			responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			errorMessage = "Error while Saving the employee Info {}";
			LOGGER.error("Error while saving the employee", e);
			responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOGGER.info("End of save(...) with resposne= {}", emp);
		return responseEntity;

	}

	public ResponseEntity<Object> getAllEmployees() {

		Employees employees = null;
		List<Employee> list = null;
		String errorMessage = "";

		ResponseEntity<Object> responseEntity = null;

		try {

			LOGGER.info("Start of getAllEmployees() ");
			employees = new Employees();

			list = employeeRepo.findAll();

			employees.setEmployeesList(list);

			responseEntity = new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {

			errorMessage = "Error while getting the list of employees from database {}";
			LOGGER.error("Error while getting the employeesList", e);
			responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End of getAllEmployees()  with employeesList={}", employees);
		return responseEntity;
	}

	public ResponseEntity<Object> getByEmpId(int empId) {

		Employee employee = null;

		String errorMessage = "";
		ResponseEntity<Object> responseEntity = null;

		try {
			LOGGER.info("Start of getByEmpId(...) with empId={}", empId);
			employee = employeeRepo.findByEmpId(empId);

			if (ObjectUtils.isEmpty(employee)) {

				responseEntity = new ResponseEntity<>("Record not found with EmpId=" + empId, HttpStatus.OK);
			} else {
				responseEntity = new ResponseEntity<>(employee, HttpStatus.OK);
			}
		} catch (Exception e) {
			errorMessage = "Failed to get Employee with empId= {} and error= {}";
			LOGGER.error("Error while getting the employee with empId= {} and exception= {}", empId, e);
			responseEntity = new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LOGGER.info("End of getByEmpId(...) with response= {}", employee);
		return responseEntity;
	}

	public ResponseEntity<String> deleteByEmpID(int empId) throws RecordNotFoundException {
		int count = 0;

		String message = "";
		ResponseEntity<String> responseEntity = null;

		try {

			LOGGER.info("Start of deleteByEmpID(...) with empId= {}", empId);
			count = employeeRepo.deleteByEmpId(empId);

			if (count == 0) {
				throw new RecordNotFoundException();
			}
			message = "deleted successfully with empId= " + empId;
			responseEntity = new ResponseEntity<>(message, HttpStatus.OK);
		} catch (RecordNotFoundException e) {
			LOGGER.warn("Record not foubnd with empId={}", empId);
			message = "Internal server error= {}";
			LOGGER.error(message, e);
			responseEntity = new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);

		} catch (Exception e) {
			LOGGER.error("Error while deleting the record with empId= {} and exception= {} ", empId, e);
			message = "Internal server error= {}";
			responseEntity = new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);

		}
		LOGGER.info("End of deleteByEmpID()");
		return responseEntity;
	}

	public ResponseEntity<Object> update(Employee employee) {
		int pkId = 0;
		int empId = 0;

		Employee emp = null;
		Employee updatedEmp = null;
		ResponseEntity<Object> responseEntity = null;
		try {
			empId = employee.getEmpId();

			LOGGER.info("Start of update(...) with empId= {}", empId);
			emp = employeeRepo.findPkIdByEmpId(empId);
			pkId = emp.getPkId();

			employee.setPkId(pkId);
			updatedEmp = employeeRepo.save(employee);

			responseEntity = new ResponseEntity<>(updatedEmp, HttpStatus.OK);

			LOGGER.info("End of update(...) with response= {}", updatedEmp);
		} catch (Exception e) {

			LOGGER.error("Failed to update", e);

			responseEntity = new ResponseEntity<>("Failed to update", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

	public ResponseEntity<Object> fetchBenchEmpInfo() {

		List<Employee> employees = null;
		BenchEmpInfoList benchEmpInfoList = null;
		ResponseEntity<Object> responseEntity = null;
		List<BenchEmployeeInfo> benchEmpInfoLists = null;
		try {

			LOGGER.info("Start of fetchBenchEmpInfo()");
			benchEmpInfoLists = new LinkedList<>();

			employees = employeeRepo.findByisActive("false");

			for (Employee employee : employees) {

				BenchEmployeeInfo benchEmpInfo = new BenchEmployeeInfo();
				benchEmpInfo.setEmpId(employee.getEmpId());
				benchEmpInfo.setExperience(employee.getExperience());
				benchEmpInfo.setSkills(employee.getSkills());

				benchEmpInfoLists.add(benchEmpInfo);
			}

			benchEmpInfoList = new BenchEmpInfoList();
			benchEmpInfoList.setBenchEmpInfos(benchEmpInfoLists);

			responseEntity = new ResponseEntity<>(benchEmpInfoList, HttpStatus.OK);

		} catch (Exception e) {
			LOGGER.error("Error while fetching the bench info", e);
			responseEntity = new ResponseEntity<>("Internal Server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		LOGGER.info("End of fetchBenchEmpInfo() with employees={}", benchEmpInfoList);
		return responseEntity;
	}

	public List<Integer> getEmpIdsForNonBgv() {

		List<Integer> list = null;
		List<Employee> employees = null;
		try {

			LOGGER.info("Start of getEmpIdsForNonBgv()");
			list = new LinkedList<>();

			employees = employeeRepo.findByIsBgvDone("false");

			for (Employee employee : employees) {
				list.add(employee.getEmpId());
			}
		} catch (Exception e) {
			LOGGER.error("Error while fetching the non-bgv employees", e);
		}
		LOGGER.info("End of getEmpIdsForNonBgv()");

		return list;
	}
}
