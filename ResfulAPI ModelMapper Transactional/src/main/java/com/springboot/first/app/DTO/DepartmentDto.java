package com.springboot.first.app.DTO;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Dapartment database table.
 * 
 */
public class DepartmentDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer deparmentId;

	private String departmentname;

	private List<EmployeeNoCertificateDto> employees;

	public DepartmentDto() {
	}

	public Integer getDeparmentId() {
		return this.deparmentId;
	}

	public void setDeparmentId(Integer deparmentId) {
		this.deparmentId = deparmentId;
	}

	public String getDepartmentname() {
		return this.departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}

	public List<EmployeeNoCertificateDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeNoCertificateDto> employees) {
		this.employees = employees;
	}
}