package tw.org.iii.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab20
 * 	20180908AM2 JDBC Driver
 */
@WebServlet("/Lab20")
public class Lab20 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 外部的Driver要放在WebContent\WEB-INF\lib
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("OK");
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
		
	
	}


}
