package com.study.springboot202212lhs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddition(){


        return "product/product_add";
    }

//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request){
//        System.out.println(request.getParameter("price"));
//
//        return "product/product_view";
//    }
    @PostMapping("/api/product")
    public String registerProduct(@RequestParam String productName,@RequestParam("price") int p){
        System.out.println(productName);
        System.out.println(p);
        return "product/product_view";
    }
}
