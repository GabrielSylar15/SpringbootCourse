package com.springboot.first.app.DTO;

import com.springboot.first.app.Entity.Department;
import com.springboot.first.app.Entity.Employee;

public class TransactionDto {
	private Department department;
	private Employee employee;
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public TransactionDto(Department department, Employee employee) {
		super();
		this.department = department;
		this.employee = employee;
	}
	public TransactionDto() {
		super();
	}
	
}
