package servlet.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *1. ServletContext 하나 받아온다
 *2. getAttribute()를 사용해 바인딩된 데이터 가져옴
 *3. 가져온 정보를 웹 브라우저로 출력
 */

@WebServlet("/Reading")
public class ReadContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//필드 추가
	private HashMap<String, String> userList;
	private ServletContext cont;
	
	@Override
		public void init() throws ServletException {
			System.out.println("init() call...Reading...");
			cont = getServletContext(); //servletConfig가 상속해줬다.. 그냥 호출해서 사용하면 됨
			System.out.println("ReadingServletContext...return..." + cont.getContextPath());
			System.out.println("ReadingServletContext...return..." + cont);
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
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		userList = (HashMap)cont.getAttribute("userList");
		
		//
		out.println("<h2>다음은 Attribute안에 바인딩된 데이터를 찾아온 결과입니다. </h2><p>"); //<p>태그는 <br>을 두번 한 것과 같다
		Set<String> set = userList.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = userList.get(key);
			out.println(key + " : " + value + "<br>");
		}//
		out.println("</body></html>");
		out.close();
	}
}
