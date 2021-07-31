package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); //새로만든 세션 아니고 계속 사용하던것 사용한다
		out.println("JSESSIONID :: " + session.getId() + "<br>");
		out.println("VO :: " + session.getAttribute("vo") + "<br>");
		out.println("Book Info :: " + session.getAttribute("book") + "<br>");
		
		//해당하는 상품에 대한 결제 로직... 다 진행되었다면..
		if(session.getAttribute("vo") != null) {//로그인된 상태라면
			//이제 세션을 죽인다.. 로그아웃 로직
			session.invalidate(); //세션 죽이는 기능.. 로그아웃 로직에 무조건 존재해야함
			out.println("<script>");
			out.println("alert('로그아웃 하시겠습니까?')");
			out.println("location.href = 'login.html'"); //자바 스크립트에서 다른 페이지로 연결..
			out.println("</script>");
		}else {//로그인 안된 상태라면
			response.sendRedirect("login.html");
			
		}
	}

}
