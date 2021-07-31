package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPass");
		
		try {
			UserVO vo = UserDAOImpl.getInstance().login(userId, password);
			HttpSession session = request.getSession();
			
			if(vo!=null) {
				session.setAttribute("vo", vo);
				request.getRequestDispatcher("loginSucess.jsp").forward(request, response);
			} else {
				response.sendRedirect("error.jsp");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
