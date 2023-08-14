package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HobbyCheckServlet extends HttpServlet {
	public HobbyCheckServlet() {
		System.out.println("HobbyCheckServlet 생성자 call...");
	}
	
	// get이나 post를 구분할 필요가 없을 경우에는
	// service를 override 해서 받아오면 됨.
	// service는 구분없이 다 받아옴.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service");
		
		// 현재 브라우저에 응답하는 문서의 한글인코딩설정
		// 이걸 넣어줘도 post로 받아온 값은 깨짐.
		response.setContentType("text/html;charset=UTF-8");
		
		// post 방식으로 받아오는 데이터 인코딩 필요
		request.setCharacterEncoding("UTF-8");
		
		// 전송된 정보를 읽어서 출력
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String hobby = request.getParameter("hobby");
		String [] hobbys = request.getParameterValues("hobby");
		
		System.out.println("name = " + name);
		System.out.println("age = " + age);
		System.out.println("hobby = " + hobby);
		System.out.println("hobbys = " + hobbys);
		
		// 하나의 이름으로 값 여러개 전달할 때
		// 브라우저 출력
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title></title></head>");
		out.print("<body>");
		out.print("<h3>");
		out.print("이름 : " + name + "<br>");
		out.print("나이 : " + age + "<br>");
		out.print("취미 : " + hobby + "<br>");
		out.print("취미 : " + hobbys + "<br>");
		for (String h : hobbys) {
			out.print(h+ ", ");
		}
		out.print("</h3>");
		out.print("</body>");
		out.print("</html>");
	}
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("get");
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("post");
//	}
}
