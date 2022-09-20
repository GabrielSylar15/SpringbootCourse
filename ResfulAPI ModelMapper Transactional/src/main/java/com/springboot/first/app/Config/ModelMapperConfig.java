package com.springboot.first.app.Config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Configuration;
import com.springboot.first.app.Entity.Employee;
import com.springboot.first.app.DTO.EmployeeDto;

@Configuration
public class ModelMapperConfig {
	public void configMapper(ModelMapper modelMapper) {
		TypeMap<Employee, EmployeeDto> typeMap = modelMapper.getTypeMap(Employee.class, EmployeeDto.class);
		if (typeMap == null) { // if not already added
			modelMapper.addMappings(new PropertyMap<Employee, EmployeeDto>() {
				protected void configure() {
					map().setDepartmentname(source.getDepartment().getDepartmentname());
				}
			});
		}
	}
}
