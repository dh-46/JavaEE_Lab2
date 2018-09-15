package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab28
 * 	20180909AM1 Cookies
 * 	後端處理種在瀏覽器上的Cookie
 * 	
 * 	1.	從request身上撈
 * 	
 * 	**	cookies是針對各自的瀏覽器, 不同的瀏覽器不同的localstorage&cookies&session
 * 	**	用戶端有可能限制cookie存取, 造成開發上的困難
 * 	
 */
@WebServlet("/Lab28")
public class Lab28 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		// 讓進出的編碼一致
		request.setCharacterEncoding("UTF-8");
		
		Cookie[] cookies = request.getCookies();
		HashMap<String, String> cookieMap = new HashMap<>();
		
		if (cookies != null) {
			for (Cookie cookie: cookies) {
				String key = cookie.getName();
				String value = cookie.getValue();
				cookieMap.put(key, value);
			}
		}
		
		if (cookieMap.containsKey("userName")) {
			writer.println(cookieMap.get("userName"));
		} else {
			writer.println("Nothing found");
		}
		
		if (cookieMap.containsKey("account")) {
			writer.println(cookieMap.get("account"));
		} else {
			writer.println("Nothing found");
		}
		
	}
}
