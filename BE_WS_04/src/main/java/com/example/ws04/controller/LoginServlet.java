package com.example.ws04.controller;

import com.example.ws04.dto.UserDto;
import com.example.ws04.service.LoginService;
import com.example.ws04.service.LoginServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        System.out.println("loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LoginService loginService = new LoginServiceImpl();
        System.out.println("request.getParameter(\"email\") = " + request.getParameter("email"));
        System.out.println("request.getParameter(\"password\") = " + request.getParameter("password"));
        UserDto dto = loginService.login(request.getParameter("email"), request.getParameter("password"));
        Gson gson = new Gson();

        Map<String, String> map = new HashMap<>();

        if (dto != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", dto);
            map.put("result", "success");

        } else {
            map.put("result", "fail");
        }
        String jsonStr = gson.toJson(map);
        response.getWriter().print(jsonStr);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        Gson gson = new Gson();
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        String jsonStr = gson.toJson(map);
        response.getWriter().print(jsonStr);
    }
}
