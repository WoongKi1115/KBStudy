package com.example.ws04.dao;

import com.example.ws04.dto.UserDto;

public interface LoginDao {
    UserDto login(String email);
}
