package servlet.header;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PHP")
public class PrintHeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public PrintHeaderServlet() {
        super();        
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성..
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		//1. 폼에 입력된 값 받아서
		String id=  request.getParameter("id");
		String password=  request.getParameter("password");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		//2. header의 정보를 다 받아온다.
		Enumeration<String> en=request.getHeaderNames();
		while(en.hasMoreElements()) {
			String key = en.nextElement();
			String value = request.getHeader(key);
			out.println(key + " : "+value+"<br>");
		}
		out.println("<hr>");
		out.println("ID :"+id+"<br>");
		out.println("PASS :"+password+"<br>");
		out.println("NAME :"+name+"<br>");
		out.println("ADDR :"+addr+"<br>");
		out.println("</body></html>");
		out.close();
	}
}
