package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MFS")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormServlet() {
        super();        
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성한다..
		/*
		 * 1. 한글처리...양방향 모두 다.
		 * 2. PrintWriter 객체 리턴 받는다.
		 * 3. 각각 폼의 값들을 다 받아온다.
		 * 4. 클라이언트의 부라우저로 받은 내용을 출력한다.
		 * 5. PrintWriter를 닫아준다.
		 */
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		String id=  request.getParameter("id");
		String password=  request.getParameter("password");
		
		String[ ] menus = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		
		String intro = request.getParameter("intro");
		
		
		out.println("<html><body>");
		out.println("<h2>폼에 입력된 값들을 출력합니다...</h2>");
		out.println("<li>당신의 아이디 "+id+"</li>");
		out.println("<li>당신의 패스워드 "+password+"</li>");
		
		out.println("<strong>선택하신 메뉴들 입니다.</strong><br>");
		String menu = "";
		for(int i=0; i<menus.length; i++) {
			menu += menus[i] +" ";
		}
		out.println(menu);
		
		out.println("<br><strong>당신의 성별은 "+gender+" 입니다.</strong><br>");
		
		out.println("<br><strong>방명록 내용입니다.</strong><br>");
		out.println(intro);
		
		out.close();		
	}
}
































