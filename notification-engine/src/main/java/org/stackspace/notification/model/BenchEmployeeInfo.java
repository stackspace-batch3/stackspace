package org.stackspace.notification.model;

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

}
