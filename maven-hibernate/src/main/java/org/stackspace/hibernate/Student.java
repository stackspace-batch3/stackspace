package org.stackspace.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT_ANNOTATION")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pkId;

	@Column(name = "STUDENT_ID")
	private int studentId;

	@Column(name = "STUDENT_NAME")
	private String name;

	@Column(name = "branch")
	private String branch;

	@Column(name = "gender")
	private String gender;

	public Student() {
		// no code
	}

	// Assign ID Generator
	public Student(int pkId, int studentId, String name, String branch, String gender) {
		super();
		this.pkId = pkId;
		this.studentId = studentId;
		this.name = name;
		this.branch = branch;
		this.gender = gender;
	}

	public Student(int studentId, String name, String branch, String gender) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.branch = branch;
		this.gender = gender;
	}

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branch == null) ? 0 : branch.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pkId;
		result = prime * result + studentId;
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
		Student other = (Student) obj;
		if (branch == null) {
			if (other.branch != null)
				return false;
		} else if (!branch.equals(other.branch))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pkId != other.pkId)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [pkId=").append(pkId).append(", studentId=").append(studentId).append(", name=")
				.append(name).append(", branch=").append(branch).append(", gender=").append(gender).append("]");
		return builder.toString();
	}

}
