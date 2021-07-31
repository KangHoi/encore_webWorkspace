package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class BookListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		try {
			ArrayList<Book> books = BookDAOImpl.getInstance().showAllBook();
			request.setAttribute("books", books);
			path = "book/bookList.jsp";
		} catch(SQLException e) {
			
		}
		
		return path;
	}
	
}
