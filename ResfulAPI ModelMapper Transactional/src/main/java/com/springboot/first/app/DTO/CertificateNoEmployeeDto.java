package com.springboot.first.app.DTO;

import java.util.List;

public class CertificateNoEmployeeDto {
	private int certificateId;
	private String cetificateName;


	public String getCetificateName() {
		return cetificateName;
	}

	public void setCetificateName(String cetificateName) {
		this.cetificateName = cetificateName;
	}

	public CertificateNoEmployeeDto(int certificateId, String cetificateName) {
		super();
		this.certificateId = certificateId;
		this.cetificateName = cetificateName;
	}

	public CertificateNoEmployeeDto() {
	}

	public int getCertificateId() {
		return this.certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

}
