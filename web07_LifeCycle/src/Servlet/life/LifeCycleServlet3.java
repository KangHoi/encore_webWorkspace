package Servlet.life;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
@WebServlet(urlPatterns ={"/LIFE3"}, loadOnStartup =1)
public class LifeCycleServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int count = 0; //필드..
	private String path = "C:\\encore_kjw\\util\\web_util\\life\\coutn.txt";
    public LifeCycleServlet3() {
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
				out.println("<html><body bgcolor=yellow>");
				out.println("<h3> LifeCycle CallBack Method... </h3>");
				out.println("<b> count :: " + ++count + "</b>");
				out.println("</body></html>");
				
				out.close();
	}//
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. init() 호출... by Container...");
		//파일에 저장된 내용을 읽어들이는 로직은 Initialization 부분인 init에서 해준다
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str = br.readLine();
			//읽어들인 count 값을 필드에 다시 할당함!!
			count = Integer.parseInt(str);
			
			System.out.println("count.txt의 값을 읽어서 필드 count에 다시 할당!! 업뎅트 성공!!");
		}catch(Exception e) {
			System.out.println("파일을 읽어들이는데 문제가 발생했습니다... fail...");
		}
	}
	
	@Override
	public void destroy() { 
		System.out.println("4. destroy() 호출... by Container...");
		//인스턴스가 메모리에서 제거되기 전에 필드 값을 영구적으로 보관... 파일에 저장
		//출력용 스트림 생성... 이곳에 필드값 출력
		
		File f = new File(path);
		//디렉토리가 현재 존재하지 않는다면 디렉토리를 먼저 만들어 놓아야 그곳에 count.txt파일이 생성
		f.getParentFile().mkdirs();
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(f));
			pw.println(count);
			pw.close();
			
			System.out.println(path + " COUNT 값 :: " + count + " 파일에 값 영구적으로 저장됨!!");
		}catch(Exception e) {
			System.out.println("출력용 스트림 생성 실패...");
		}
	}

}
