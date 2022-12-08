package com.study.springboot202212lhs.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {


    @Autowired

    private StudentService studentService;
    @Autowired
    private Test1 T1;
    @Autowired
    private Test2 T2;

    @ResponseBody
    @GetMapping("/student")
    public String printStudent(){
        Student student = Student.builder()
                .studentId(2001)
                .studentName("이혜성")
                .build();

        T1.print();
        T2.print();


        studentService.printStudentInfo(student);

        return  null;
    }
}
