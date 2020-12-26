package org.stackspace.employee.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackspace.employee.bindings.PreviousExperienceInfos;
import org.stackspace.employee.service.PreviousCompaniesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/stackspace/pre-exp")
@Api(value = "It will provide previous experience of employees")
public class PreviousExperienceResource {

	private static final Logger LOGGER = LoggerFactory.getLogger(PreviousExperienceResource.class);

	@Autowired
	private PreviousCompaniesService service;

	@ApiOperation(value = "Previous employees list retrived successfully")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully retrived"),
			@ApiResponse(code = 500, message = "Failed to retrive/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	@GetMapping(produces = { "application/xml", "application/json" })
	public ResponseEntity<Object> getPreviousExperienceInfo() {

		ResponseEntity<Object> responseEntity = null;
		try {

			LOGGER.info("Start of getPreviousExperienceInfo()");
			responseEntity = service.getAll();

		} catch (Exception e) {
			LOGGER.error("Error while getting the previous experience info", e);
		}

		LOGGER.info("End of getPreviousExperienceInfo()");
		return responseEntity;
	}

	@ApiOperation(value = "It will save the employee previous companies data into database")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully saved"),
			@ApiResponse(code = 201, message = "successfully created"),
			@ApiResponse(code = 500, message = "Failed to save/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	@PostMapping(consumes = { "application/json", "application/xml" }, produces = { "application/json",
			"application/xml" })
	public ResponseEntity<Object> save(@RequestBody PreviousExperienceInfos experienceInfos) {

		ResponseEntity<Object> responseEntity = null;

		try {

			LOGGER.info("Start of save(...)");
			responseEntity = service.save(experienceInfos);

			LOGGER.info("End of save(...) with respone= {}", responseEntity);
		} catch (Exception e) {
			LOGGER.error("Error while saving the PreviousExperienceInfos", e);
			responseEntity = new ResponseEntity<>("Server problum", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;
	}

}
