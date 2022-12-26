package com.study.springboot202212lhs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

//필수
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private int userId;
    @Pattern(regexp = "^[a-zA-Z0-9][5,20]$",message = "사용자 이름은 영문,숫자 조합이어야하며<br> 5자 이상 20자 이하로 작성하세요")
    private String username;

    private String password;
    @Pattern(regexp = "^[가-힇][2,5]$",message = "이름은 한글만 작성 가능하며<br> 2자 이상최대 5자 이하만 입력가능합니다")
    private String name;
    @NotBlank(message = "이메일을 입력해주세요")
    @Email
    private String email;
}
