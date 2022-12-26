package com.study.springboot202212lhs.repository;

import com.study.springboot202212lhs.dto.EmployeeDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeRepository {
    public int saveEmployee(EmployeeDto employeeDto);

}
