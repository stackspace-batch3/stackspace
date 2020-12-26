package org.stackspace.bgv.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stackspace.bgv.service.BgvService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/stackspace/bgv")
@Api(value = "It will provide BGV pending employees information")
public class BgvResource {

	@Autowired
	private BgvService bgvService;

	@ApiOperation(value = "Health check")
	@GetMapping("/check")
	public String check() {
		return "Bgv application is up and running...";
	}

	@ApiOperation(value = "Return BGV pending info")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "successfully retrived"),
			@ApiResponse(code = 500, message = "Failed to retrive/ internal server error"),
			@ApiResponse(code = 404, message = "url not existed") })
	@GetMapping(produces = { "application/xml", "application/json" })
	public ResponseEntity<Object> info() {
		return bgvService.getList();
	}
}
