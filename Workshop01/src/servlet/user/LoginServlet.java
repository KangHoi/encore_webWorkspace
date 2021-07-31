package servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * <servlet>
 *  <servlet-name>LoginServlet
 *  <servlet-class>servlet.use.LoginServlet
 * </servlet>
 * <servlet-mapping>
 *  <servlet-name>LoginServlet
 *  <url-pattern>/LoginServlet
 * </servlet-mapping>
 * 
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//2. 받은 값을 다시 웹브라우저로 전송해서 출력
		//서버 설정 먼저 병경 --> 그런 다음 서버 plug-in
		//request.setCharacterEncoding("UTF-8"); //이 부분 지금은 적용 안됨
		response.setContentType("text/html;charset=utf-8"); //printwriter응답 전에 해줘야함
		PrintWriter out = response.getWriter();
		
		//1. 폼에 입력된 값 받아서
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		out.println("<html><body>");
		out.println("<h3><b>" + id + "</b>님이 로그인되었습니다!!!</h3>");
		out.println("<a href='#'>도서 등록</a><br>");
		out.println("<a href='#'>로그 아웃</a>");
		out.println("</body></html>");
	}
}
