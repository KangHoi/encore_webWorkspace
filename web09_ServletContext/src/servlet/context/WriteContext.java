package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 1. 폼값 받는다. getParameter()
 * 2. 받은 값을 가지고 객체 생성
 * 3. ServletContext를 반환받는다... ServletConfig의 getServletContext()
 * 	  ServletContext에 바인딩... SetAttribute()
 * 4. 바인딩된 정보를 다음 서블릿이 가져다 쓸 수 있도록 페이지 연결
 */

@WebServlet("/Writing")
public class WriteContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//필드 추가
	private HashMap<String, String> userList;
	private ServletContext cont;
	
	@Override
		public void init() throws ServletException {
			System.out.println("init() call...Reading...");
			cont = getServletContext(); //servletConfig가 상속해줬다.. 그냥 호출해서 사용하면 됨
			System.out.println("WritingServletContext...return..." + cont.getContextPath());
			System.out.println("WritingServletContext...return..." + cont);
			userList = new HashMap<String, String>();
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
		
		String userId = request.getParameter("userId");
		String userPass = request.getParameter("userPass");
		String userName = request.getParameter("userName");
		
		//userList에 담는다.
		userList.put("userId",userId);
		userList.put("userPass",userPass);
		userList.put("userName",userName);
		
		//바인딩
		cont.setAttribute("userList", userList);
		
		PrintWriter out = response.getWriter();
		//페이지 연결
		out.println("<html><body bgcolor=pink>");
		out.println("<b> ========== Data Writing.... ServletContext ========= <br>");
		out.println("사용자의 정보가 등록되었습니다... </b><br><br>");
		
		//다음 서블릿으로 연결
		out.println("<a href ='Reading'> 접속자 명단 보기 </a>");
		out.println("</body></html>");
		out.close();
		
	}
}
