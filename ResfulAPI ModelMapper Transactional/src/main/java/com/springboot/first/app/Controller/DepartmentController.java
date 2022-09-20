package com.springboot.first.app.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.first.app.DTO.DepartmentDto;
import com.springboot.first.app.DTO.TransactionDto;
import com.springboot.first.app.Entity.Department;
import com.springboot.first.app.Entity.Employee;
import com.springboot.first.app.Service.DepartmentService;
import com.springboot.first.app.Service.ServiceImp.TransactionImp;
@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;
	@Autowired
	TransactionImp transactionImp;
	@GetMapping("/api/department/list")
	public List<DepartmentDto> getList(){
		return departmentService.getAll();
	}
	
	@PostMapping({"/api/department/create","/api/department/update"})
	public ResponseEntity<Department> create(@RequestBody DepartmentDto departmentDto){
		return departmentService.update(departmentDto);
	}
	
	@DeleteMapping("/api/department/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		departmentService.delete(id);
		return new ResponseEntity<String>("Delete successfully", HttpStatus.OK);		
	}
	
	@PostMapping("/api/department/test")
	public ResponseEntity<String> test(@RequestBody TransactionDto transactionDto){
		transactionImp.testTransaction(transactionDto.getDepartment(), transactionDto.getEmployee());
		return new ResponseEntity<String>("Successfully", HttpStatus.OK);
		
	}
}
