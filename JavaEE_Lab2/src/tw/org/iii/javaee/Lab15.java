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
 * 	Servlet implementation class Lab15
 * 	20180908AM1 Forward
 * 	=> 整個內容forward Lab16, 但使用者看到的依然是Lab15
 * 	
 * 	NOTE:
 * 	大部分在玩的都是request的變化
 * 	response=>基本上就只是輸出
 */
@WebServlet("/Lab15")
public class Lab15 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("Lab16");
		
		out.println("<h1>Lab 15</h1>");
		
		String name = request.getParameter("name");
		if (name == null) {
			dispatcher1.forward(request, response);
		} else {
			out.println("Hello, "+ name);
		}
	}

}
