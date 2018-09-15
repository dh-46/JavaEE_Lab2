package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	20180902PM1
 * 	get資料練習
 * 
 */

@WebServlet("/Lab06")
public class Lab06 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String x1 = request.getParameter("x");
		String y1 = request.getParameter("y");
		int x = 0;
		int y = 0;
		
		try {
			x = Integer.parseInt(x1);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		
		try {
			y = Integer.parseInt(y1);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
		
		int ans = x + y;
		PrintWriter writer = response.getWriter();
		writer.append(x + " + " + y + " = " + ans);
		writer.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
