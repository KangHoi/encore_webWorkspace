package servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//////브라우저의 모든 쿠키 정보를 받아오는 로직을 작성 //////////////////////////////////////////////
		//1)cookies[ ] =  req.getCookies()  2) 그 중에서 내가 원하는 쿠키 정보를 뽑아서 바인딩
		
		ArrayList<String> fruits = new ArrayList<String>();
		
		Cookie[ ] cookies = request.getCookies();
		if(cookies!=null) {
			for(Cookie c : cookies) {
				if(c.getName().startsWith("fruitshop")) 
					fruits.add(c.getValue());//해당 사이트의 오늘본 상품 이미지들이 추가됨..
			}//for
		}//if
		
		request.setAttribute("fruits", fruits);
		
		///////////////////////////////////////////////////////////////////////////////////////////////
		
		ArrayList<Item> list=ItemDao.getInstance().getAllItem();
		System.out.println(list);
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}
}
