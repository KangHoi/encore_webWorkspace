package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAO;
import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class IdListController implements Controller{

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("list", MemberDAOImpl.getInstance().getIdList());
			
		} catch (SQLException e) {
			
		}
		return new ModelAndView("show_idList.jsp");
	}
}
