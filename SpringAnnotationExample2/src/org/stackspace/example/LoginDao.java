package org.stackspace.example;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

	public void validate() {
		System.out.println("valid");
	}
}
