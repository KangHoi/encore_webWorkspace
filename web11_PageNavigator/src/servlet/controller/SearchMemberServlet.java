package servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/SMS")
public class SearchMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직 여기 작성..
		/*
		 * 1. 폼 값 받아서
		 * ( 값 하나이므로 vo생성 필요 없음 )
		 * 2. DAO리턴 받고
		 * 3. 비즈니스로직 호출 결과로 vo객체 리턴 받고
		 * 4. 리턴 받은 값을 Attribute에 바인딩  --- 어떤 Attribute를 사용할건지 잘 생각한다.
		 * 5. 네비게이션 -- - 서버 내에 있는 jsp로 바로 이동
		 * 
		 */
		PrintWriter out =response.getWriter();
		String id = request.getParameter("id");
		//DAO비즈니스 로직 호출했다 치고.. 
		
		request.setAttribute("id", id);
		//request.getRequestDispatcher("result_view.jsp").forward(request, response);
		request.getRequestDispatcher("includetest1.jsp").include(request, response);
		
		out.println("<h2>이 부분 보일까요?</h2>"); // 되돌아올 일이 없으므로 보이지 않는다. forward를 사용했으므로 .. include에서는 출력된다!		
		
	}
}









/*
 * RequestDispatcher가 가지고 있는 forward(req, res), include(req,res)방식의 페이지 이동 방법
 * 
 * 1. forward방식
 * forward하려는 페이지로 현재 서블릿의 모든 권한을(req,res)가지고 서버 내에 있는 다른 페이지로 직접 이동
 * 제어권이 완전히 이동하는 페이지로 가버리므로 다시 이전 서블릿으로 되돌아오지 않는다.
 * 따라서 서블릿에서 응답 관련 객체 PrintWriter사용할 일이 없음. 철저히 로직 중심으로 작성
 * 
 * 또한, 결과 페이지의 url 주소를 살피면, 
 * 결과페이지인 jsp 주소가 아니라 이전 서블릿 주소로 출력되어진다.
 * 모든 권한 (req, res)를 가지고 이동했으므로 서블릿 이름으로 주소가 명시되어진다
 * 
 * 
 * 2. include방식
 * 만약 서블릿의 PrintWriter객체를 이용하려 한다면 include방식으로 페이지 이동할 수 있다.
 * include에 담긴 모든 내용을 가지고 서블릿에 포함되어지므로 inlcuding 한 다음 다시 서블릿 이후 과정을 마무리 짓고
 * 서블릿이 직접 응답할 수 있다.
 * 
 * 하지만 이렇게 사용되는 부분은 거의 없고 위 1번처럼 주로 forwarding방식을 훨씬 더 많이 사용한다.
 */
