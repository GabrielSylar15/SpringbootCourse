package com.springboot.first.app.Service.ServiceImp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.first.app.DTO.CertificateDto;
import com.springboot.first.app.Repository.CertificateRepostitory;
import com.springboot.first.app.Service.CertificateService;

@Service
public class CertificateServiceImp implements CertificateService {
	@Autowired
	CertificateRepostitory certifcateRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<CertificateDto> getListCertificates() {
		return certifcateRepository.findAll().stream().map(p -> modelMapper.map(p, CertificateDto.class))
				.collect(Collectors.toList());
	}
}
