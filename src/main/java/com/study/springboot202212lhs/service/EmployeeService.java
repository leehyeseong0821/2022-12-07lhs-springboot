package com.study.springboot202212lhs.service;

import com.study.springboot202212lhs.dto.EmployeeDto;
import com.study.springboot202212lhs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public int addEmployee(EmployeeDto employeeDto){

        return employeeRepository.saveEmployee(employeeDto)>0 ? employeeDto.getEmpId() :0;
    }

}
