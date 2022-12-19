package com.study.springboot202212lhs.repository;

import com.study.springboot202212lhs.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
}
