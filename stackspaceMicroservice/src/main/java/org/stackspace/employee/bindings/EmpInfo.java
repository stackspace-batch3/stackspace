package org.stackspace.employee.bindings;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "emp-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmpInfo {

	@XmlElement(name = "emp-id")
	private int empId;

	@XmlElement(name = "exp-info")
	private List<ExpInfo> expInfo;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public List<ExpInfo> getExpInfo() {
		return expInfo;
	}

	public void setExpInfo(List<ExpInfo> expInfo) {
		this.expInfo = expInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpInfo [empId=").append(empId).append(", expInfo=").append(expInfo).append("]");
		return builder.toString();
	}

}
