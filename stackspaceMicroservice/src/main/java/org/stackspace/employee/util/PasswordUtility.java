package org.stackspace.employee.util;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class PasswordUtility {

	public String encript(String value) {
		return Base64.getEncoder().encodeToString(value.getBytes());
	}

	public String decript(String value) {
		return new String(Base64.getDecoder().decode(value));

	}
}
