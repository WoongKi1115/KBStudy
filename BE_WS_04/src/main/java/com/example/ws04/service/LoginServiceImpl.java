package com.example.ws04.service;

import com.example.ws04.dao.LoginDao;
import com.example.ws04.dao.LoginDaoImpl;
import com.example.ws04.dto.UserDto;

public class LoginServiceImpl implements LoginService{
    @Override
    public UserDto login(String email, String password) {
        LoginDao dao = new LoginDaoImpl();
        UserDto dto = dao.login(email);
        if (dto.getPassword().equals(password)) {
            dto.setPassword(null);
            return dto;
        }
        return null;
    }
}
