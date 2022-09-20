package com.springboot.first.app.Service;

import java.util.List;

import com.springboot.first.app.Repository.EmployeeRepository.BestEmployeeDto;
import com.springboot.first.app.DTO.EmployeeDto;
import com.springboot.first.app.Entity.Employee;

public interface EmployeeService {
	public List<EmployeeDto> getListEmployee();
	public List<BestEmployeeDto> getBestEmployee(int page_index);
	public EmployeeDto getDetaiEmployeeDto(Integer id);
	public EmployeeDto create(Employee employee);
	public void deleteEmployee(Integer id);
	public EmployeeDto edit(EmployeeDto employeeDto);
	public void createEmployeeCertificate(Employee employee);
	public void createEmployeeForTransaction(Employee e);
	public void createEmployeeCheckedException(Employee e);
}
