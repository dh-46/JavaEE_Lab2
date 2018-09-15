package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	20180902PM1
 * 	讓畫面更新時不是跳轉而是直接更新
 * 	增強Lab06
 * 	如何與前端互動
 * 
 * 	網路上傳遞的資料訊息	=> 字串!
 */

@WebServlet("/Lab07")
public class Lab07 extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String x1 = request.getParameter("x");
		String y1 = request.getParameter("y");
		String select = request.getParameter("choose");
		String result = "";
		boolean isInit = true;
		int x = 0;
		try {
			x = Integer.parseInt(x1);
			isInit = false;
		} catch (NumberFormatException e) {
			System.out.println(e);
			x1 = "";
		}
		
		int y = 0;
		try {
			y = Integer.parseInt(y1);
		} catch (NumberFormatException e) {
			System.out.println(e);
			y1 = "";
		}
		
		if (!isInit) {
			int ans = 0;
			switch (select) {
			case "1":
				ans = x + y;
				break;
			case "2":
				ans = x - y;
				break;
			case "3":
				ans = x * y;
				break;
			case "4":
				ans = x / y;
				break;
			}
			result += ans;
		} else {
			select = "1";
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.append("<form action='Lab07' method='post'>");
		writer.append("<input type='text' name='x' "+ "value='"+ x1 +"'>");
		//writer.append(" + "); // 換成下拉式選單
		writer.append(" <select name='choose'> ");
		writer.append("<option value='1' "+ (select.equals("1")?"selected":"") +">+</option>");
		writer.append("<option value='2' "+ (select.equals("2")?"selected":"") +">-</option>");
		writer.append("<option value='3' "+ (select.equals("3")?"selected":"") +">x</option>");
		writer.append("<option value='4' "+ (select.equals("4")?"selected":"") +">/</option>");
		writer.append(" </select> ");
		writer.append("<input type='text' name='y' "+ "value='"+ y1 +"'> ");
		writer.append("<input type='submit' value='=' >"); 
		writer.append(" " + result);
		writer.append("</form>");
		writer.flush();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
