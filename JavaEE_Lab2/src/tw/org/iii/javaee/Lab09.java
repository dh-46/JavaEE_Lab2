package tw.org.iii.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	20180902PM2
 * 	
 * 	取得表單中的多個值
 * 
 */

@WebServlet("/Lab09")
public class Lab09 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gender = request.getParameter("gender");
		System.out.println(gender);
		
		//String hobby = request.getParameter("hobby");
		//System.out.println(hobby);
		
		String[] hobbies = request.getParameterValues("hobby"); // 取得多個值
		for (String hobby : hobbies) {
			System.out.println(hobby);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
