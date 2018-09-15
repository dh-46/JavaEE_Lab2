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
 * 	Servlet implementation class Lab32
 * 	20180909AM2 Session2
 * 	
 */
@WebServlet("/Lab32")
public class Lab32 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		//	不創建新的session/要拿現在的
		HttpSession session = request.getSession(false);
		if (session == null) {
			//	趕走
			response.sendRedirect("lab22.html");
		} else {
			// 合法登入
			Member member = (Member)session.getAttribute("member2");
			writer.println(member.getName() + " : "+ member.getAccount());
			writer.println("<hr>");
			writer.println("<a href='Logout'>Logout</a>");
		}
	}

}
