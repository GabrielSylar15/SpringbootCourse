package com.springboot.first.app.Service.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.first.app.Entity.Department;
import com.springboot.first.app.Entity.Employee;
import com.springboot.first.app.Exception.NotFoundItemException;
import com.springboot.first.app.Service.DepartmentService;
import com.springboot.first.app.Service.EmployeeService;

@Service
public class TransactionImp {
	@Autowired
	EmployeeService employeeService;

	@Autowired
	DepartmentService departmentService;

	@Transactional(rollbackFor = Exception.class)
	public void testTransaction(Department d, Employee e) {
		departmentService.createDepartment(d);
		employeeService.createEmployeeCheckedException(e);
	}
}
