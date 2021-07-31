package Servlet.life;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LIFE1")
public class LifeCycleServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0; //필드..
	
    public LifeCycleServlet1() {
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
				
				//클라이언트의 요청이 몇 번 들어왔는지를 count하는 로직 작성
				out.println("<html><body bgcolor='yellow'>");
				out.println("<h3> LifeCycle CallBack Method... </h3>");
				out.println("<b> count :: " + ++count + "</b>");
				out.println("</body></html>");
				
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
