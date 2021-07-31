package servlet.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Member;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServletContext cont;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			PrintWriter out = response.getWriter();
			
			/*
			 * 1. 폼값 받아서
			 * 2. 받은 값으로 vo객체 생성
			 * 3. ServletContext 리턴 후 vo 객체 바인딩
			 * 4. 페이지 이동.. a태그로 이동.. result.jsp로 이동한다.
			 */
			
			// 1. 
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String address = request.getParameter("address");
			
			//2.
			Member vo = new Member(name, age, address);
			
			//3.
			cont = getServletContext();
			cont.setAttribute("vo", vo);
			
			//4.
			out.println("<a href=result.jsp> 결과 확인하러 가기 </a>");
			out.close();

	}
}
