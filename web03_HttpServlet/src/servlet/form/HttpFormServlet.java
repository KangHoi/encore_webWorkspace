package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormServlet")
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 클라이언트 폼 값을 받는다..
		String name = request.getParameter("name");
		String addr = request.getParameter("address");
		
		//2. 받은 값을 DB가서 잘 연결했다 간주하고
		//3. 다시 화면으로 응답... 출력..
		// Tomas Hello!
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>");
		out.println("Your Name Information... </h3><br>");
		out.println("<li> Your Name " + name);
		out.print("</li></body></html>");
		out.close();
		
	}

}
