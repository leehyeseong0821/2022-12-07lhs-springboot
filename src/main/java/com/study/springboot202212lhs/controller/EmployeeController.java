package com.study.springboot202212lhs.controller;


import com.study.springboot202212lhs.dto.CMRespDto;
import com.study.springboot202212lhs.dto.EmployeeDto;
import com.study.springboot202212lhs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto){

        return  ResponseEntity.created(null).body(new CMRespDto<>("직원등록완료", employeeService.addEmployee(employeeDto)));
    }
}
