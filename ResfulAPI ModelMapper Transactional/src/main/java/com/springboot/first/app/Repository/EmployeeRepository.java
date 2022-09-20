package com.springboot.first.app.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.first.app.Entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	interface BestEmployeeDto{
		Integer getNumCertificate();
		String getName();
		Integer getEmployeeId();
		String getDepartmentName();
		String getDob();
	}
	@Query(value="select e.employee_id as employeeId,e.name, departmentname, COUNT(*) as numCertificate\r\n"
			+ "from employee as e left join Department as d on e.deparartment_id = d.deparment_id\r\n"
			+ "						   left join employee_certificate as ec on e.employee_id = ec.employee_id\r\n"
			+ "						   left join certificate as c on ec.certificate_id = c.certificate_id 		\r\n"
			+ "						   group by e.name, e.dob, departmentname, e.employee_id order by numCertificate desc", nativeQuery = true)
	List<BestEmployeeDto> getBestEmployees(Pageable pageable);
}
