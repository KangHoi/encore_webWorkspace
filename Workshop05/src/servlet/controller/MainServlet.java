package servlet.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.ProductVO;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//필드 추가.. ArrayList, ServletContext...
	
	List<ProductVO> list = Collections.synchronizedList(new ArrayList<ProductVO>());
	
	@Override
	public void init() throws ServletException {
		System.out.println("ServletContext Address :: " + getServletContext());
		getServletContext().setAttribute("list", list);
		System.out.println("ServletContext에 상품 정보들을 하나씩 저장합니다... List 바인딩 ok..");
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); 
		String price = request.getParameter("price"); 
		String desc = request.getParameter("desc"); 
		
		ProductVO pvo = new ProductVO(name, price, desc);
		System.out.println("2. 폼 값을 받아서 pvo 생성...");
		
		list.add(pvo); //ServletContext에 List를 박아넣음
		System.out.println("3. List에 상품 정보를 저장함...");
		
		//페이지 이동...네비게이션
		request.getRequestDispatcher("register.jsp").forward(request, response);
		//forward를 사용했으므로 register.jsp에서 request가 작동함
	}

}
