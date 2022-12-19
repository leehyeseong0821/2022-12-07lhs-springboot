package com.study.springboot202212lhs.repository;

import com.study.springboot202212lhs.dto.UserDto;

public interface UserRepository {

    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
}
