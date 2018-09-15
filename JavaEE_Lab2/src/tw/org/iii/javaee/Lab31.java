package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	Servlet implementation class Lab31
 * 	20180909AM2 Session
 * 	
 * 	=>	存在於request身上
 * 	
 * 	servlet有四種層級存取
 * 	1.	Page Conext: 層級最小
 * 	2.	Request: 兩頁面之間
 * 	3.	Session: 多次Request
 * 	4.	Application: 全server
 * 	=> 四者都有attribute 
 * 
 * 	這個範例模擬會員登入成功後要做的事情
 */
@WebServlet("/Lab31")
public class Lab31 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();	// 取得session
		
		Member member = new Member("Tom", "tom1234", 50);
		session.setAttribute("member", member);
		
		writer.println("add session");
		
		//	session.setMaxInactiveInterval(0); //	設為0永遠不會timeout(瀏覽器關閉才會關掉)
		//	session.getLastAccessedTime();	// 上次存取的時間
		//	session.isNew(); 	// 判斷是否為新的session
	}

}
