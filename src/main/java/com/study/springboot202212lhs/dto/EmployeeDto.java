package com.study.springboot202212lhs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDto {

    private int empId;
    private String empName;
    private int empAge;
    private String empPhone;
}
