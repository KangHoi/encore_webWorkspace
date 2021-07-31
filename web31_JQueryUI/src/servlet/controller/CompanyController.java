package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CompanyController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("CompanyComponent... 진입...");
		//비즈니스 로직 돌았다 치고
		String result = "<ui><li> Tomato System </li><br>"
				+ "<li> NCSoft Coporation </li><br>"
				+ "<li> LG CNS </li><br>"
				+ "<li> EAST Engineering </li><br>"
				+ "<li> KTDS Company </li><br></ul>";
		
		request.setAttribute("result", response);
		return new ModelAndView("Result.jsp");
	}

}
