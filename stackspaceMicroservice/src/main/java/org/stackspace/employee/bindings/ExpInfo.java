package org.stackspace.employee.bindings;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "exp-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExpInfo {

	@XmlElement(name = "company-name")
	private String name;

	@XmlElement(name = "prv-company-empId")
	private String empId;

	@XmlElement(name = "prv-company-email")
	private String email;

	@XmlElement(name = "prv-company-hrEmail")
	private String hrMail;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHrMail() {
		return hrMail;
	}

	public void setHrMail(String hrMail) {
		this.hrMail = hrMail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExpInfo [name=").append(name).append(", empId=").append(empId).append(", email=").append(email)
				.append(", hrMail=").append(hrMail).append("]");
		return builder.toString();
	}

}
