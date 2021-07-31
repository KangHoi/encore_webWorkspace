package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubjectController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("SubjectComponent.. 진입.. ");
		//비즈니스 로직.. 엔코아 주요 과목 이수 과목을 db에서 꺼내온다... 돌아갔다 치고
		String result = "Big Data | Machine Learning | DeepLearning | Python | Restful API Service | Vue CLI";
		
		request.setAttribute("result", result);
		
		return new ModelAndView("Result.jsp"); //forwarding 방식으로 이동..
		
	}

}
