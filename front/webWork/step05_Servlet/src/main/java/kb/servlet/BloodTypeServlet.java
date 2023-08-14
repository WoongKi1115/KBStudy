package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BloodTypeServlet extends HttpServlet {
	
	public BloodTypeServlet() {
		System.out.println("BloodType");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String name = request.getParameter("name");
		String blood = request.getParameter("blood");
		// 1. redirect 방식 : 새로운 request, response가 생성되서 이동
//		System.out.println(blood);
//		name = URLEncoder.encode(name, "UTF-8");
		
		// url 형태로 보내줌.(데이터를 담아서)
//		// 여기서 name 에 한글이 들어가면 에러가 생김.
//		// 때문에 인코딩을 맞춰서 보내주어야 함.
//		// WAS에서 한글 데이터를 전송할 때 인코딩 설정이 필요함.
//		// name = URLEncoder.encode(name, "UTF-8");
//		// 이걸로 변환 후 전송하면 안 깨짐.
//		response.sendRedirect(blood +".jsp?name=" + name+"&blood="+blood);		
	
	// 2. forward 방식 : 기존의 request, response 그대로 유지
		request.getRequestDispatcher(blood + ".jsp").forward(request, response);
	
	}
}
