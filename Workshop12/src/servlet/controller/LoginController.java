package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String path = "error.jsp";
		
		try {
			UserVO rvo = UserDAOImpl.getInstance().login(id, password);
			
			if(rvo != null) {//로그인 성공했으면...
				HttpSession session = request.getSession();
				session.setAttribute("mvo", rvo);
				path = "loginSuccess.jsp";
			}			
		} catch(SQLException e) {
			System.out.println(e);
		}
		
		return path;
	}
	
}
