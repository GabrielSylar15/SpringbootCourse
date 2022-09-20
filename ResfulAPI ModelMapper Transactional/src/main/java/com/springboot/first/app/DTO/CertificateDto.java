package com.springboot.first.app.DTO;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.List;

public class CertificateDto implements Serializable {

	private int certificateId;

	private List<EmployeeNoCertificateDto> employees;

	public CertificateDto() {
	}

	public int getCertificateId() {
		return this.certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public List<EmployeeNoCertificateDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeNoCertificateDto> employees) {
		this.employees = employees;
	}

}