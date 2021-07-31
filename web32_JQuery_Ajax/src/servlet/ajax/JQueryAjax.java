package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JQueryAjax")
public class JQueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼값 받아서
		String id = request.getParameter("id");
		//바인딩 생력
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		//네비게이션
		request.getRequestDispatcher("resultView.jsp").forward(request,response);
		
	}

}
