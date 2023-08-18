package com.example.ws03.controller;

import com.example.ws03.dao.BannerDaoImpl;
import com.example.ws03.service.BannerServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/banner")
public class BannerServlet extends HttpServlet {
    private static BannerServiceImpl bannerService = BannerServiceImpl.getInstance();

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = bannerService.listBanner();
        Gson gson = new Gson();
        String jsonArray = gson.toJson(list);

        System.out.println(jsonArray);
        PrintWriter out = resp.getWriter();
        out.print(jsonArray);
    }
}
