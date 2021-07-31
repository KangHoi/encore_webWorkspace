package servlet.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.Member;


@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String path;
	private ArrayList<Member> members = new ArrayList<Member>();

    
	private ServletContext cont;

	@Override
	public void init() throws ServletException {
		System.out.println("init() call...");
		
		path = getInitParameter("path");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] strs = line.split(" ");
				members.add(new Member(strs[0], strs[1], strs[2], strs[3]));
			}
			br.close();
		} catch (Exception e) {
			
		}
	} 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		
		// 1. 
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		//2.
		Member vo = new Member(id, password, name, address);
		
		//3.
		cont = getServletContext();
		cont.setAttribute("vo", vo);
		
		Member member = null;
		String requestId = request.getParameter("id");
		String requestPassword = request.getParameter("password");
		for(Member m : members) {
			if (m.getId().equals(requestId)) member = m;
		}
		
			PrintWriter out = response.getWriter();
			if(member ==null) {
				out.println("<a href='success.jsp?id=" + requestId + "&password=" + requestPassword + "&name=" + member.getName() + "&address=" + member.getAddress()+"'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>");
				//out.println("<a href='error.jsp?id=requestId'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>");
				
			} else {
				out.println("<a href='error.jsp?id=requestId'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>");
				//out.println("<a href='success.jsp?id=" + requestId + "&password=" + member.getPassword() + "&name=" + member.getName() + "&address=" + member.getAddress()+"'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>");
			}
			out.close();
		}
			



}

