package com.springboot.first.app.Service;

import java.util.List;

import com.springboot.first.app.DTO.CertificateDto;
public interface CertificateService {
	public List<CertificateDto> getListCertificates();
}
