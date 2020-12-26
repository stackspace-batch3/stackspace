package org.stackspace.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServicce {

	@Autowired
	private LoginDao loginDao;

	public void ValidateLoginInfo() {
		System.out.println("ValidateLoginInfo()");
		loginDao.validate();
	}
}
