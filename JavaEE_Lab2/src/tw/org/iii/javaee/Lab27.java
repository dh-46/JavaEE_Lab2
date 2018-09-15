package tw.org.iii.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab27
 * 	20180909AM1 認識Cookies
 * 	後端建立在瀏覽器的cookie
 * 
 * 	cookie有分建在伺服端或用戶端?
 * 
 * 	應用: 遊戲/銀行操作秒數
 */
@WebServlet("/Lab27")
public class Lab27 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		Cookie cookieRemember = new Cookie("remember", "true"); //	做出物件實體
		cookieRemember.setMaxAge(1*60);		// cookie活多久 單位秒
		response.addCookie(cookieRemember); 	//	
		
		Cookie cookieRemember1 = new Cookie("userName", "JohnDoe"); //	做出物件實體
		cookieRemember1.setMaxAge(1*60);		// cookie活多久 單位秒
		response.addCookie(cookieRemember1); 	//	
		
		Cookie cookieRemember2 = new Cookie("password", "123456"); //	做出物件實體
		cookieRemember2.setMaxAge(1*60);		// cookie活多久 單位秒
		response.addCookie(cookieRemember2); 	//	
		
		Cookie cookieRemember3 = new Cookie("account", "asd123"); //	做出物件實體
		cookieRemember3.setMaxAge(1*60);		// cookie活多久 單位秒
		response.addCookie(cookieRemember3); 	//	
	}

}
