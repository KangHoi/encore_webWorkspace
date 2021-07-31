package com.encore;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println("command : " + command);
		
		if(command.equals("wordCount")) {
			wordCount(request, response);
		}else if(command.equals("kickCount")) {
			kickCount(request, response);
		}
	}//doProcess


	//해당 모듈 안에서만 사용되고 다른 모듈에서는 불려지는 일이 없을 때 함수 앞에 private
	private void wordCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String words = request.getParameter("words");
		
		//알고리즘 자바 클래스의 execute 함수 호출.. Count 클래스 객체 생성
		String result = new Count().execute(words);
		request.setAttribute("result", result);
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}
	

	private void kickCount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String fname = request.getParameter("fname");
		
		String path = request.getServletContext().getRealPath("/res");
		File file = new File(path, fname);
		int count = new Kickboard().execute(file);
		request.setAttribute("result", count);
		request.getRequestDispatcher("Result.jsp").forward(request, response);

	}

}
