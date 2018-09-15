package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab17
 * 	20180908AM2 認識MVC
 * 	假設要處理複雜的運算, 將工作交給Lab18
 * 
 * 	Lab17 負責拿到x,y	/ 控制 Control => 中心位置
 * 	Lab18 負責處理 Modal 
 * 	Lab19 負責呈現 View
 * 	==> MVC
 * 	
 * 	註: 目前的主流是Spring
 */
@WebServlet("/Lab17")
public class Lab17 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//	0. Prepare
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		if (x == null) {
			x="0";
		}
		
		if (y == null) {
			y="0";
		}
		
		//	1. 交給model(Lab18)處理
		Lab18 model = new Lab18(x, y);
		int result = model.add();
		
		//	2. view
		RequestDispatcher dispatcher = request.getRequestDispatcher("Lab19?result=" + result + "&x=" + x + "&y=" + y);
		
		//	Lab19 現在擁有x,y,result 三個參數
		dispatcher.forward(request, response);
		
	}


}
