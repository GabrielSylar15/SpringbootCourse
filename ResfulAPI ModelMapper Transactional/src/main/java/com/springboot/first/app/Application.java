package com.springboot.first.app; 

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
// 
@SpringBootApplication
public class Application {
//	Deep knowledge:
// 	https://techmaster.vn/posts/36436/p1-transaction-long-nhau-trong-ung-dung-java-spring-boot-hoac-quarkus-nested-transaction-in-java-application
// 	https://techmaster.vn/posts/36443/p2-transaction-long-nhau-trong-ung-dung-je1ava-spring-boot-hoac-quarkus-nested-transaction-in-java-application
//	Checked Exception: Exception was checked by tools (sytax error) in compile time (Exp: EmployeeService->createEmployeeCheckedException)
// 	Unchecked Exception: Logic Exception, exception was throw when some errors happen in runtime (Exp: Convert a string to Integer)
//	@Transactional auto rollback when UncheckedException happen
// 	If we don't want to rollback when unchecked exception happen we can use property: dontRollbackOn
	
//	Nested Transaction: (TransactionImp->testTransaction)
//	If we don't use @Transaction, departmentRepostiory.save(d) and employeeRepository.save(e) still work and update in database.
//	METHOD testTransaction MUST BE IN OUTSIDE CLASS (CANNOT BE DepartmentServiceImp or EmployeeServiceImp) when we want to "REQUIRES_NEW" and
//	createDepartment(DepartmentServiceImp->createDepartment) still works and save data into database 
//	https://stackoverflow.com/questions/37217075/spring-nested-transactions

	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();    
	}
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
