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

@Entity
@Table(name = "previous_experience_info")
@XmlRootElement(name = "PreviousExperienceInfo")
@XmlAccessorType(XmlAccessType.FIELD)
public class PreviousExperienceInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	@JsonIgnore
	private int pkId;

	@Column(nullable = false, unique = false)
	private int stackspaceEmpId;

	@Column(nullable = false, unique = false)
	private String companyName;

	@Column(nullable = false, unique = true)
	private String empId;

	@Column(nullable = false, unique = false)
	private String email;

	@Column(nullable = false, unique = false)
	private String hrEmail;

	@Column(nullable = false, unique = false)
	private Date startDate;

	@Column(nullable = false, unique = false)
	private Date endDate;

	public int getPkId() {
		return pkId;
	}

	public void setPkId(int pkId) {
		this.pkId = pkId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getHrEmail() {
		return hrEmail;
	}

	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getStackspaceEmpId() {
		return stackspaceEmpId;
	}

	public void setStackspaceEmpId(int stackspaceEmpId) {
		this.stackspaceEmpId = stackspaceEmpId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PreviousExperienceInfo [pkId=").append(pkId).append(", companyName=").append(companyName)
				.append(", empId=").append(empId).append(", email=").append(email).append(", hrEmail=").append(hrEmail)
				.append(", startDate=").append(startDate).append(", endDate=").append(endDate).append("]");
		return builder.toString();
	}

}
