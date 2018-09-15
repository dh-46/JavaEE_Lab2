package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lab02
 */

/*	20180902AM2
 * 	封包: Header+Body (資訊在Header中)
 * 	
 * 	HTTP: 無狀態(每次要求)
 * 	後端: 讓HTTP看起來像有狀態
 */

@WebServlet("/Lab02")
public class Lab02 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String name = headerNames.nextElement();
			String value = request.getHeader(name);
			writer.append(name + ":" + value + "<br>");
			// writer.append(name+ "<br>");
			System.out.println(name);
		}
		writer.flush();
		// writer.close(); 不用寫 會自動關閉
	}

}
