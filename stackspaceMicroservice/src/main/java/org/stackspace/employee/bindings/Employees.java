package org.stackspace.employee.bindings;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.stackspace.employee.entity.Employee;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employees {

	@XmlElement(name = "employee")
	private List<Employee> employeesList;

	public List<Employee> getEmployeesList() {
		return employeesList;
	}

	public void setEmployeesList(List<Employee> employeesList) {
		this.employeesList = employeesList;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employees [employeesList=").append(employeesList).append("]");
		return builder.toString();
	}

}
