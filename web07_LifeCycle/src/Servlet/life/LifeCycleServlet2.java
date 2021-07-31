package Servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 클라이언트의 요청을 처리한 결과
 * 즉 필드에 지정된 COUNT값을 서블릿이 출력하지 않고
 * 정보를 jsp에 넘기고
 * 결과 페이지 처리를 jsp가 하도록 로직을 수정
 * 이때
 * 페이지 연결방법을 사용해야하나
 * 단순히 우리가 이미 알고 있는 방법인 a태그(href 속성에 jsp페이지 연결)를 이용하자
 */
@WebServlet(urlPatterns ={"/LIFE2"}, loadOnStartup =1)
public class LifeCycleServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0; //필드..
	
    public LifeCycleServlet2() {
    	System.out.println("1. LifeCycleServlet1 생성자 호출... by Container...");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("3. service() --> doGet() or doPost() 호출... by Container..."); //service부분만 반복적으로 호출
		//로직은 여기서 작성..
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = response.getWriter();
				count++;
				
			/* 이 부분 내용이 jsp에 들어가는 것이 역할 분담에 더 맞다
				//out.println("<h3> LifeCycle CallBack Method... </h3>");
				//out.println("<b> count :: " + ++count + "</b>");
				//out.println("</body></html>");
			 */

				out.println("<a href=life2.jsp?cnt="+count+"> 여기를 클릭하시면 jsp페이지로 이동합니다. </a>"); //이때 COUNT값을 가지고 JSP로 가려면?
				out.close();
	}//
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. init() 호출... by Container...");
	}
	
	@Override
	public void destroy() { //서버를 끄면 호출된다.. Servlet Instance가 메모리에서 내려온다
		System.out.println("4. destroy() 호출... by Container...");
	}

}
