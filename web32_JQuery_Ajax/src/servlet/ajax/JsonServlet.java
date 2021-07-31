package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import domain.Weather;


@WebServlet("/JsonServlet")
public class JsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//1. JSON 객체를 하나 생성.. json.jar가 있어야함
		JSONObject json = new JSONObject();
		
		//2. Weather객체 생성
		Weather weather  =new Weather();
		weather.setRegion("NY");
		weather.setWind(44);
		weather.setTemp(23);
		weather.setRain(46);
		
		//3. 객체를 json에 put
		json.put("weather", weather);
		
		//4. 객체를 전송
		out.print(json);
		
	}
	


}
