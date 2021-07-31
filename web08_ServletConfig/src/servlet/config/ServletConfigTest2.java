package servlet.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletConfigTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //필드 추가...
	private String path;
	private String custid;
	
    public ServletConfigTest2() {
        System.out.println("생성자 호출... instance 이 때 생성 됩니다..");
    }

    @Override
    public void init() throws ServletException {
    	  System.out.println("init() call...");
    	  //저장된 파일의 값을 읽어서 필드에 할당... 로직을 작성
    	  path = getInitParameter("path");
    	  System.out.println("init()... configTest2...");
    	  try {
    		  BufferedReader br = new BufferedReader(new FileReader(path));
    		  custid = br.readLine(); 
    		  System.out.println("고객 정보... credit no..." + custid);
    		  
    		  br.close();
    	  }catch(Exception e) {
    		  
    	  }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				
				PrintWriter out = response.getWriter();
				//폼으로부터 받아온 값 읽어온다... getParameter(); .. getInitParameter()와 시점이 완전 다르고 통로도 다르다!
				String custname = request.getParameter("cust");
				
				out.println("<html><body bgcolor=yellow>");
				out.println("<h2> A Servlet Configuration... Using ServletConfig</h2>");
				
				out.println("<h3>" + custname + "," + custid + "로 인증되었습니다.. 서비스 진행 가능 합니다...");
				out.println("</body></html>");
				out.close();
	}

}
