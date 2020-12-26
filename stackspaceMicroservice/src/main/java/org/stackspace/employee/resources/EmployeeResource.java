package org.stackspace.employee.resources;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackspace.employee.beans.PropertyConfigurationBean;
import org.stackspace.employee.entity.Employee;
import org.stackspace.employee.service.EmployeeService;
import org.stackspace.employee.util.PasswordUtility;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/stackspace/employee")
@Api(description = "It will provide emplyees information")
public class EmployeeResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeResource.class);

	@Autowired
	private Environment env;

	@Autowired
	private PasswordUtility passwordUtility;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private PropertyConfigurationBean propertyBean;

	@PostMapping(consumes = { "application/xml", "application/json" }, produces = { "application/xml",
			"application/json" })

	@ApiOperation(value = "It will save the employee information into database" + " and return saved employee info")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 500, message = "Failed to save/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	public ResponseEntity<Object> save(@RequestBody Employee employee) {

		ResponseEntity<Object> responseEntity = null;
		try {
			LOGGER.info("Start of save(...)");

			responseEntity = employeeService.save(employee);

			LOGGER.info("End of save() and response= {}", responseEntity);
		} catch (Exception e) {
			LOGGER.error("Error while saving the employee", e);
		}

		return responseEntity;
	}

	@ApiOperation(value = "It will send employee list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully retrived"),
			@ApiResponse(code = 500, message = "Failed to retrive/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	@GetMapping(produces = { "application/xml", "application/json" })
	public ResponseEntity<Object> getAll() {

		ResponseEntity<Object> responseEntity = null;

		try {
			LOGGER.info("Start of getAll()");
			responseEntity = employeeService.getAllEmployees();

			LOGGER.info("End of getAll() with resppnse= {}", responseEntity);
		} catch (Exception e) {
			LOGGER.error("Error while grtting employees list", e);
		}
		return responseEntity;
	}

	@ApiOperation(value = "It will send emp info based by EmpId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrived"),
			@ApiResponse(code = 500, message = "Failed to retrive/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	@GetMapping(value = "/{empId}", produces = { "application/xml", "application/json" })
	public ResponseEntity<Object> getEmployeeByEmpId(@PathVariable("empId") @ApiParam("It is employee Id") int empId) {

		ResponseEntity<Object> responseEntity = null;
		try {

			LOGGER.info("Start of getEmployeeByEmpId(...) with empId= {}", empId);

			responseEntity = employeeService.getByEmpId(empId);

		} catch (Exception e) {

			LOGGER.error("Error while getting employee with empId={}", empId, e);
		}

		LOGGER.info("End of getEmployeeByEmpId(...) with empId= {}", empId);
		return responseEntity;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully deleted"),
			@ApiResponse(code = 500, message = "Failed to delete/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	@DeleteMapping(value = "/{empId}")
	public ResponseEntity<String> delete(@PathVariable("empId") @ApiParam("empId") int empId) {

		ResponseEntity<String> responseEntity = null;

		try {

			LOGGER.info("Start of delete(...) with empId= {}", empId);

			responseEntity = employeeService.deleteByEmpID(empId);

			LOGGER.info("End of delete(...) with responseEntity={}", responseEntity);
		} catch (Exception e) {

			LOGGER.error("Internal server error= {}", e);
		}

		return responseEntity;
	}

	@ApiOperation(value = "It will update the employee based on EmpId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully updated"),
			@ApiResponse(code = 500, message = "Failed to update/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	@PutMapping(consumes = { "application/xml", "application/json" }, produces = { "application/xml",
			"application/json" })
	public ResponseEntity<Object> update(@RequestBody Employee employee) {

		int empId = 0;
		ResponseEntity<Object> responseEntity = null;
		try {
			empId = employee.getEmpId();

			LOGGER.info("Start of update(...) with empId={}", empId);

			responseEntity = employeeService.update(employee);

			LOGGER.info("End of update(...) with response= {}", responseEntity);
		} catch (Exception e) {

			LOGGER.error("Error while updating the employee with empId={}", empId, e);
		}

		return responseEntity;
	}

	@GetMapping("db/info")
	@ApiOperation(value = "Return database information")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 500, message = "Failed to save/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })

	public Map<String, Object> dbIno() {

		Map<String, Object> map = new LinkedHashMap<>();

		map.put("url", env.getProperty("stackspace.datasource.url"));
		map.put("un", propertyBean.getUserName());
		map.put("pwd", passwordUtility.decript(propertyBean.getPassword()));
		map.put("dialect", propertyBean.getPlatform());

		return map;
	}

	@GetMapping(value = "/info", produces = { "application/json", "application/xml" })
	@ApiOperation(value = "It will return bench employees information list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Fetched bench employees list successfully"),
			@ApiResponse(code = 500, message = "Failed to save/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	public ResponseEntity<Object> getBenchEmpInfo() {

		ResponseEntity<Object> responseEntity = null;

		try {

			LOGGER.info("Start of getBenchEmpInfo()");
			responseEntity = employeeService.fetchBenchEmpInfo();

			LOGGER.info("End of getBenchEmpInfo() with response={}", responseEntity);
		} catch (Exception e) {
			LOGGER.error("Error while fetching the bench info", e);
		}
		return responseEntity;
	}
}
