package org.stackspace.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "stackspace_employee")
@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
@ApiModel
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id")
	@XmlTransient
	@JsonIgnore
	private int pkId;

	@Column(nullable = false, unique = true, name = "emp_id")
	@JsonProperty("empId")
	@ApiModelProperty(value = "It is auto generated value by system")
	private int empId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String gender;

	@Column(nullable = false)
	private float salary;

	@Column(nullable = false, unique = true, name = "mobile_no")
	private long mobileNo;

	@Column(nullable = false)
	private float experience;

	@Column(nullable = false)
	private String skills;

	@Column(nullable = false, name = "contact_preference")
	private String contactPreference;

	@Column(nullable = false)
	private String department;

	@Column(nullable = false, name = "date_of_birth")
	private Date dateOfBirth;

	@Column(nullable = false, name = "is_active")
	@ApiModelProperty(value = "If value is false means employee is in Bench")
	private String isActive;

	@Column(name = "photoPath")
	private String photoPath;

	@Column(nullable = false)
	@ApiModelProperty(value = "It is auto generated value by system")
	private String designation;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false, name = "IS_BGV_DONE")
	private String isBgvDone;

	public Employee() {
		super();
	}

	public Employee(int pkId, int empId, String name, String email, String gender, float salary, long mobileNo,
			float experience, String skills, String contactPreference, String department, Date dateOfBirth,
			String isActive, String photoPath, String designation, String address, String isBgvDone) {
		super();
		this.pkId = pkId;
		this.empId = empId;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.salary = salary;
		this.mobileNo = mobileNo;
		this.experience = experience;
		this.skills = skills;
		this.contactPreference = contactPreference;
		this.department = department;
		this.dateOfBirth = dateOfBirth;
		this.isActive = isActive;
		this.photoPath = photoPath;
		this.designation = designation;
		this.address = address;
		this.isBgvDone = isBgvDone;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
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

	public String getContactPreference() {
		return contactPreference;
	}

	public void setContactPreference(String contactPreference) {
		this.contactPreference = contactPreference;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIsBgvDone() {
		return isBgvDone;
	}

	public void setIsBgvDone(String isBgvDone) {
		this.isBgvDone = isBgvDone;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [pkId=").append(pkId).append(", empId=").append(empId).append(", name=").append(name)
				.append(", email=").append(email).append(", gender=").append(gender).append(", salary=").append(salary)
				.append(", mobileNo=").append(mobileNo).append(", experience=").append(experience).append(", skills=")
				.append(skills).append(", contactPreference=").append(contactPreference).append(", department=")
				.append(department).append(", dateOfBirth=").append(dateOfBirth).append(", isActive=").append(isActive)
				.append(", photoPath=").append(photoPath).append(", designation=").append(designation)
				.append(", address=").append(address).append(", isBgvDone=").append(isBgvDone).append("]");
		return builder.toString();
	}

}
