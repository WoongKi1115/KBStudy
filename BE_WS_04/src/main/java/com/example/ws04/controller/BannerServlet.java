package com.example.ws04.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.ws04.service.BannerService;
import com.example.ws04.service.BannerServiceImpl;
import com.google.gson.Gson;

@WebServlet("/banners") //생성  + 매핑
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
		BannerService bannerService = new BannerServiceImpl();
		List<String> bannerList = bannerService.listBanner();
		
	
		
		Gson gson = new Gson();
		//String jsonStr = gson.toJson(bannerList); //list그래도 보내면 front 에서 result  그냥 사용
		
		Map<String, List<String>> map = new HashMap<>();
		map.put("banners", bannerList);
		
		String jsonStr = gson.toJson(map); // map으로 보내면 front 에서 result.key  그냥 사용
		System.out.println(jsonStr);
		
		response.getWriter().print(jsonStr);
	}

}

// ParameterTest.html 사용