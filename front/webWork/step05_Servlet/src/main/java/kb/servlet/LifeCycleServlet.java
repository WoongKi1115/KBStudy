package kb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet 작성하는 방법
 * 1) HttpServlet 상속
 * 2) public class
 * 3) 필요한 메서드 재정의
 * 4) web.xml or @annotation 등록
 * @author student
 *
 */
public class LifeCycleServlet extends HttpServlet {
	
	public LifeCycleServlet() {
		System.out.println("LifeCycleServlet 생성자 call....");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LifeCycleServlet init call....");

	}
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("LifeCycleServlet service call....");
//		
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LifeCycleServlet doGet call....");
		
		// 현재 브라우저에 응답하는 문서의 한글인코딩설정 필요
		response.setContentType("text/html;charset=UTF-8");
		
		// 브라우저에 출력
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>Servlet Start</title></head>");
		out.print("<body>");
		out.println("<h1 style='color:red'> Servlet 시작하기 <h1>");
		out.print("</body>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LifeCycleServlet doPost call....");

	}

	@Override
	public void destroy() {
		System.out.println("LifeCycleServlet destroy call....");

	}

	
	
}
