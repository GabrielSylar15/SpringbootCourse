package com.springboot.first.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.first.app.DTO.CertificateDto;
import com.springboot.first.app.Service.CertificateService;
@RestController
public class CertificateController {
	@Autowired
	CertificateService certificateSerivce;
	
	@GetMapping("/api/certificate/list")
	public List<CertificateDto> listCertificate(){
		return certificateSerivce.getListCertificates();
	}
}
