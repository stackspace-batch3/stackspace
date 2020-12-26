package org.stackspace.employee.bindings;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "bgv-pending-emp-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class BgvPendingEmpInfo {

	@XmlElement(name = "emp-info")
	private List<EmpInfo> empInfo;

	public List<EmpInfo> getEmpInfo() {
		return empInfo;
	}

	public void setEmpInfo(List<EmpInfo> empInfo) {
		this.empInfo = empInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BgvPendingEmpInfo [empInfo=").append(empInfo).append("]");
		return builder.toString();
	}

}
