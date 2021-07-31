package servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Book;
import servlet.model.BookDAOImpl;

public class AddBookController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String path = "";
		
		String[] bookNoList = request.getParameterValues("bookNo");
		String isbn = "";
		for(int i=0; i<bookNoList.length; i++) {
			if(i==bookNoList.length-1) {
				isbn += bookNoList[i];
			} else {
				isbn += bookNoList[i] + "-";
			}
		}
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));		
		String description = request.getParameter("bookSummary");
		
		servlet.model.Book bvo = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price,  description);
		System.out.println("book Creating..");
		try {
			BookDAOImpl.getInstance().registerBook(bvo);
			request.setAttribute("bvo", bvo);
			path = "book/bookSuccess.jsp";
		} catch(SQLException e) {
			e.printStackTrace();
		}		
		
		return path;
	}

}