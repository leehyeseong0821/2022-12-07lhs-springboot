package com.study.springboot202212lhs.controller;

import com.study.springboot202212lhs.dto.CMRespDto;
import com.study.springboot202212lhs.dto.UserDto;
import com.study.springboot202212lhs.exception.CustomTestException;
import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/str")
    public String getUserDtoStr(){

        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();

        return userDto.toString();
    }

    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj(){

        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();

            HttpHeaders headers = new HttpHeaders();
             headers.set("UserDto",userDto.toString());
//            return new ResponseEntity<>(headers,HttpStatus.OK);
               return ResponseEntity.ok().headers(headers).body(userDto);
//              return new ResponseEntity<>(userDto, HttpStatus.BAD_REQUEST);
//              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(userDto);
    }
    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();

            return  ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답",userDto));

    }
    @PostMapping("/api/test/user")
        public ResponseEntity<?> addUser(@RequestBody UserDto userDto){

            if(userDto.getUsername().isBlank()){
                Map<String,String> errorMap = new HashMap<>();
                errorMap.put("username","아이디를 입력하세요.");

                throw new CustomTestException("유효성 검사 실패",errorMap);
            }

            userDto.setUserId(200);
            return ResponseEntity.created(null)
                    .body(new CMRespDto<>(userDto.getUserId()+"사용자 추가 성공!",userDto));
        }
}
