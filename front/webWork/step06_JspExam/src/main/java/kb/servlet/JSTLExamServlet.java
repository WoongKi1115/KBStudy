package kb.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLExamServlet
 * web.xml 문서에 등록 대신
 * @annotation으로 변경
 * 
 * 클래스 위에
 * @WebServlet("/info") -> 생성 + 매핑
 * 
 * @WebServlet({urlpatterns={"/info"}, load-})
 * 
 */
@WebServlet("/JSTLExamServlet")
public class JSTLExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSTLExamServlet() {
    	System.out.println("JSTLExamServlet");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.service(req, resp);
    }

}
