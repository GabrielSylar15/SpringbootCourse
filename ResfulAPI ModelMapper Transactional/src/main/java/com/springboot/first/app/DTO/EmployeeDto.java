package com.springboot.first.app.DTO;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

public class EmployeeDto implements Serializable {

	private int employeeId;

	private String dob;

	private String email;

	private boolean gender;

	private String name;
	
	private String departmentname;
	
	private List<CertificateNoEmployeeDto> certificates;

	public EmployeeDto() {
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CertificateNoEmployeeDto> getCertificates() {
		return this.certificates;
	}

	public void setCertificates(List<CertificateNoEmployeeDto> certificates) {
		this.certificates = certificates;
	}

}