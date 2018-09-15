package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * 	Servlet implementation class Lab29
 * 	20180909AM1
 * 	
 * 	servlet上的例外
 */
@WebServlet("/Lab29")
public class Lab29 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		
		int a = 10, b = 0;
		try {
			writer.println(a/b);
		} catch (Exception e) {
			//	例外處理一: 誤導使用者XD : 錯誤訊息頁
			//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Server Busy");
			
			//	帶走
			response.sendRedirect("Lab30");
			System.out.println(e);
		}
		
		
		
	}


}
