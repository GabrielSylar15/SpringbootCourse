package com.springboot.first.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.DTO.EmployeeDto;
import com.springboot.first.app.Entity.Employee;
import com.springboot.first.app.Service.ServiceImp.EmployeeServiceImp;
import com.springboot.first.app.Repository.EmployeeRepository.BestEmployeeDto;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeServiceImp employeeServiceImp;
	
	@GetMapping("/api/employee/list")
	public List<EmployeeDto> showListEmployee(){
		return employeeServiceImp.getListEmployee();
	}
	
	@GetMapping("/api/employee/bestemployee")
	public List<BestEmployeeDto> showbestEmployee(@RequestParam("page_index") int page_index){
		return employeeServiceImp.getBestEmployee(page_index);
	}
	
	@PostMapping("/api/employee/create")
	public ResponseEntity<EmployeeDto> create(@RequestBody Employee employee){
		return new ResponseEntity<EmployeeDto>(employeeServiceImp.create(employee), HttpStatus.OK);
	}
	
	@PostMapping("/api/employee/createCheckedException")
	public void createEmployeeCheckedException(@RequestBody Employee employee){
		employeeServiceImp.createEmployeeForTransaction(employee);
	}	
	
	
	@GetMapping("/api/employee/detail/{id}")
	public EmployeeDto detail(@PathVariable("id") Integer id) {
		return employeeServiceImp.getDetaiEmployeeDto(id);
	}
	
}
