package servlet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("itemnumber"));
		
		//count증가...로직을 함꼐 작성
		boolean result=ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+result);
		
		Item item=ItemDao.getInstance().getItem(itemnum);
		System.out.println("getItem()? "+item);
		

		//오늘 본 상품정보를 쿠키에 저장하는 로직 추가...
		//1) 쿠키 생성("key", "value") 2) 쿠키 저장 시간을 24시간으로 지정 setMaxAge()  3) 정보가 저장된 쿠키를 클라이언트로 보냄
		
		Cookie cookie = new Cookie("fruitshop"+itemnum, item.getUrl());//1)
		cookie.setMaxAge(24*60*60);//2)
		response.addCookie(cookie);//3)
				
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}
