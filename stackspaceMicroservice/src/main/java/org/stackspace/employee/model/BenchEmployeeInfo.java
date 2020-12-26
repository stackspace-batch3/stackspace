package org.stackspace.employee.model;

import io.swagger.annotations.ApiModel;

@ApiModel
public class BenchEmployeeInfo {

	private int empId;

	private float experience;

	private String skills;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
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
		builder.append("BenchEmployeeInfo [empId=").append(empId).append(", experience=").append(experience)
				.append(", skills=").append(skills).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + Float.floatToIntBits(experience);
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BenchEmployeeInfo other = (BenchEmployeeInfo) obj;
		if (empId != other.empId)
			return false;
		if (Float.floatToIntBits(experience) != Float.floatToIntBits(other.experience))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}

}
