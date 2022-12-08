package com.study.springboot202212lhs.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IocController {
    //하나의 객체를 bean


    @Autowired
    @Qualifier("usi3")
    //IOC 컨테이너에 등록하고 오토와일드를 만나면 IOC 컨테이너를 스캔하여 UserService 객체에 자동으로 DI를 한다.
            //인터페이스를 쓰는 목적은 하나의 PC에 모니터 빔프젝처럼 UserServiceImp 1,2,3가 있기때문에 여러개를 쓸 수 있다.
    private UserService userService;


    @ResponseBody
    @GetMapping("/ioc")
    public String iocTest(){
        userService.createUser();
        userService.getUser();
        userService.updateUser();
        userService.deleteUser();
        return null;
    }
}
