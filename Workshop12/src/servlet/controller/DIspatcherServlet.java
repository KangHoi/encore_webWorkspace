package servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/front.do", loadOnStartup = 1)
public class DIspatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. command 값 받아서
		// 2. 공장한테 command 값 준다...Controller 타입을 반환
		// 3. Controller의 메소드를 호출하면 Component의 메소드가 호출된다(Overriding)...path를 리턴
		// 4. path를 갖고 페이지 이동
		String command = request.getParameter("command");
		String path = "login.html"; // default : error page || home
		
		Controller controller = ControllerFactory.getInstance().createController(command);
		
		try {
			path = controller.execute(request, response);
		} catch (Exception e) {
			
		}
		
		request.getRequestDispatcher(path).forward(request, response);//redirect방식..
	}
	
}
