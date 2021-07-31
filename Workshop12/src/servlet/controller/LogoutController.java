package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "loginSuccess.jsp";
		
		HttpSession session = request.getSession();

		if (session.getAttribute("mvo") != null) {
			session.invalidate();
			path = "logout.jsp";
		}
		
		return path;
	}

}
