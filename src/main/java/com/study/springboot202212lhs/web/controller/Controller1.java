package com.study.springboot202212lhs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller1 {

    //@RequestMapping(value = "/page1", method =RequestMapping.GET)
    @GetMapping("/page1")
    public String page1(){

        return "page1";
    }


}
