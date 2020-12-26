package org.stackspace.boot.crud.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffResource {

	@GetMapping(value = "staff")
	public String getAllStaff() {
		return "All staff";
	}

	// localhost:9090/student/123/John
	@GetMapping(value = "/staff/{id}/{name}")
	public String getStaff(@PathVariable("name") String staffName, @PathVariable("id") String staffId) {
		// DB Logic
		return staffId + "-" + staffName;
	}
}
