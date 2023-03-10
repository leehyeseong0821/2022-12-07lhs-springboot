package com.study.springboot202212lhs.controller.account;


import com.study.springboot202212lhs.aop.annotation.ParamsAspect;
import com.study.springboot202212lhs.aop.annotation.PrintTestAspect;
import com.study.springboot202212lhs.aop.annotation.TimerAspect;
import com.study.springboot202212lhs.aop.annotation.ValidAspect;
import com.study.springboot202212lhs.dto.CMRespDto;
import com.study.springboot202212lhs.dto.UserDto;
import com.study.springboot202212lhs.dto.UsernameDto;
import com.study.springboot202212lhs.exception.CustomValidException;
import com.study.springboot202212lhs.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {
//     아래 Slf4j 어노테이션으로 대체
//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class);
    @Autowired
    private UserService userService;


    @ParamsAspect
    @TimerAspect
    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) {

        userService.duplicateUsername(usernameDto.getUsername());

        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }

}