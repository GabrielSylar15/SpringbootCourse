package com.springboot.first.app.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springboot.first.app.DTO.DepartmentDto;
import com.springboot.first.app.Entity.Department;
import com.springboot.first.app.Entity.Employee;

public interface DepartmentService {
	public List<DepartmentDto> getAll();

	public ResponseEntity<Department> update(DepartmentDto d);

	public void delete(Integer id);

	public void createDepartment(Department d);
}
