package org.stackspace.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANNOTATION_EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pkId;

	@Column(name = "EMP_ID")
	private int empId;

	@Column(name = "EMP_NAME")
	private String name;

	@Column
	private String skills;

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [pkId=").append(pkId).append(", empId=").append(empId).append(", name=").append(name)
				.append(", skills=").append(skills).append("]");
		return builder.toString();
	}

}
