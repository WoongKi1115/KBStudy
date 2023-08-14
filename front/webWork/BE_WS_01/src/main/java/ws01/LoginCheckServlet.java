package ws01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckServlet extends HttpServlet {
	public LoginCheckServlet() {
		System.out.println("LoginCheckServlet");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbId = "nwk";
		String dbPassword = "123123";
		
		String id = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		String name = request.getParameter("userName");
		
		if (dbId.equals(id) && dbPassword.equals(password)) {
			request.getRequestDispatcher("loginOk.jsp").forward(request, response);
		}
	}
}
