package com.example.ws04.service;

import com.example.ws04.dto.UserDto;

public interface LoginService {
    UserDto login(String email, String password);
}
