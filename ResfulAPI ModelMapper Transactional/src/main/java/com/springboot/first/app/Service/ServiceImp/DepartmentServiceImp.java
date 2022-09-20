package com.springboot.first.app.Service.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.first.app.DTO.DepartmentDto;
import com.springboot.first.app.Entity.Department;
import com.springboot.first.app.Entity.Employee;
import com.springboot.first.app.Exception.NotFoundItemException;
import com.springboot.first.app.Repository.DepartmentRepository;
import com.springboot.first.app.Repository.EmployeeRepository;
import com.springboot.first.app.Service.DepartmentService;
import com.springboot.first.app.Service.EmployeeService;

@Service
public class DepartmentServiceImp implements DepartmentService{
	@Autowired
	DepartmentRepository departmentRepostiory;
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeService employeeService;
	@Override
	public List<DepartmentDto> getAll() {
		return departmentRepostiory.findAll().stream().map(dep -> modelMapper.map(dep, DepartmentDto.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public ResponseEntity<Department> update(DepartmentDto d) {
		Department department = modelMapper.map(d, Department.class);
		return new ResponseEntity<Department>(departmentRepostiory.save(department), HttpStatus.CREATED);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		departmentRepostiory.deleteById(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void createDepartment(Department d) {
		departmentRepostiory.save(d);
	}

}
