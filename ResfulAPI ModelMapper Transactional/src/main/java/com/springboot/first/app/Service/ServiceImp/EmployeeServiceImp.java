package com.springboot.first.app.Service.ServiceImp;

import java.util.List;
import java.util.stream.Collectors;



import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.first.app.DTO.EmployeeDto;
import com.springboot.first.app.Entity.Employee;
import com.springboot.first.app.Repository.EmployeeRepository;
import com.springboot.first.app.Repository.EmployeeRepository.BestEmployeeDto;
import com.springboot.first.app.Service.EmployeeService;
import com.springboot.first.app.Exception.NotFoundItemException;
import com.springboot.first.app.Config.ModelMapperConfig;
@Service
public class EmployeeServiceImp implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
		
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	ModelMapperConfig context;
	
	@Override
	public List<EmployeeDto> getListEmployee() {
		// TODO Auto-generated method stub
//		Firstway: Config the emplpoyeedto's information by using mapping
//		return employeeRepository.findAll().stream().map(temp -> {
//            EmployeeDto ed = modelMapper.map(temp, EmployeeDto.class);
//            ed.setDepartmentname(temp.getDepartment().getDepartmentname());
//            return ed;
//        }).collect(Collectors.toList());
//		--------------------------
//		Secondway: Config PropertyMap:
		context.configMapper(modelMapper);
		return employeeRepository.findAll().stream().map(x -> modelMapper.map(x, EmployeeDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public List<BestEmployeeDto> getBestEmployee(int page_index) {
		return employeeRepository.getBestEmployees(PageRequest.of(page_index-1, 5));
	}

	@Override
	public EmployeeDto getDetaiEmployeeDto(Integer id) {
		context.configMapper(modelMapper);
		return modelMapper.map(employeeRepository.findById(id).orElseThrow(() -> new NotFoundItemException("Cannot find that employee")) 
			, EmployeeDto.class);
	}

//	Transaction chỉ rollback với uncheckedexception, để rollback với checkedexeption, phải thêm (rollbackOn = );
// 	Depper knowledge: https://medium.com/geekculture/spring-transactional-rollback-handling-741fcad043c6#:~:text=In%20Spring%20Boot%2C%20when%20%40Transactional,changes%20if%20an%20exception%20occurred.
	
	@Override
//	@Transactional(rollbackFor = {NumberFormatException.class})
	public EmployeeDto create(Employee employee){
		EmployeeDto employeeDto = modelMapper.map(employeeRepository.save(employee), EmployeeDto.class);
//		if(true) throw new NumberFormatException();
		return employeeDto;
	}
	
	@Override
	public void createEmployeeCertificate(Employee employee) {
		// TODO Auto-generated method stub
	}
	
//	Checked Exception	
	@Override
	@Transactional
	public void createEmployeeCheckedException(Employee e) {
		employeeRepository.save(e);
		Integer.parseInt("aaaa");
//		throw new Exception("test");
	}	
	
	
	@Override
	public void createEmployeeForTransaction(Employee e) {
		employeeRepository.save(e);
	}
	

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EmployeeDto edit(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		return null;
	}


}
