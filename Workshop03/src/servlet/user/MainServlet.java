package servlet.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet(
		urlPatterns = { "/MainServlet" },
		initParams = {
				@WebInitParam(name = "path", value = "C:\\encore_lss\\util\\web_util\\userinfo\\member.txt")
		},
		loadOnStartup = 1
		)
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private String path;
	private ArrayList<User> users = new ArrayList<User>();
	
	public void init() throws ServletException {
		System.out.println("init() call...");
		
		path = getInitParameter("path");
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = br.readLine()) != null) {
				String[] strs = line.split(" ");
				users.add(new User(strs[0], strs[1], strs[2], strs[3]));
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String reqId = request.getParameter("id");
		String reqPassword = request.getParameter("password");
		
		// user 있는지 확인
		User user = null;
		for (User u : users) {
			if (u.getId().equals(reqId)) user = u;
		}

		PrintWriter out = response.getWriter();
		if (user != null) {
			if (user.getPassword().equals(reqPassword))
				out.println("<a href='loginSuccess.jsp?id=" + reqId + "&password=" + reqPassword + "&name=" + user.getName() + "&address=" + user.getAddress() + "'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>");
			else
				out.println("<a href='error.jsp?error=password'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>");
		} else {
			out.println("<a href='error.jsp?error=id'>여기를 클릭하시면 JSP페이지로 이동합니다.</a>");
		}
	}

}
