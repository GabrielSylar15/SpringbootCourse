package com.springboot.first.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.app.Entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>{

}
