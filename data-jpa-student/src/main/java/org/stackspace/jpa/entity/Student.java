
package org.stackspace.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "STUDENT_JPA")
@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "Student.getByStudentName", query = "from Student where studentName=:name")
@NamedNativeQuery(name = "Student.findByStudentIdNative", query = "Select * from Student_Jpa where student_id=?",resultClass = Student.class)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlElement
	private int id;

	@Column(name = "STUDENT_ID")
	@XmlElement(name = "student-id")
	private int studentId;

	@Column(name = "STUDENT_NAME")
	@XmlElement(name = "student-name")
	private String studentName;

	@Column
	@XmlElement
	private int age;

	@Column
	@XmlElement
	private String gender;

	@Column
	@XmlElement
	private String domain;

	@Column
	@XmlElement
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [id=").append(id).append(", studentId=").append(studentId).append(", studentName=")
				.append(studentName).append(", age=").append(age).append(", gender=").append(gender).append(", domain=")
				.append(domain).append(", address=").append(address).append("]");
		return builder.toString();
	}

}
