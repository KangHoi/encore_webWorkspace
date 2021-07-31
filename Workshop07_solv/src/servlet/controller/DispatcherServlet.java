package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Book;
import servlet.model.BookDAOImpl;
import servlet.model.UserDAOImpl;
import servlet.model.UserVO;

@WebServlet("/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getParameter("command");
		String path = "login.html";
		
		if(command.equals("login")) {
			path = login(request, response);
		}else if(command.equals("addbook")) {
			path = addbook(request, response);
		}
		
		request.getRequestDispatcher(path).forward(request, response);		
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	
	protected String addbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "";
		String isbn = request.getParameter("bookNo");
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));		
		String description = request.getParameter("bookSummary");
		
		Book bvo = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price,  description);
		System.out.println("book Creating..");
		try {
			
			BookDAOImpl.getInstance().registerBook(bvo);
			request.setAttribute("bvo", bvo);
			path = "book/bookSuccess.jsp";
		} catch(SQLException e) {
			
		}		
		
		return path;
	}
	
}
