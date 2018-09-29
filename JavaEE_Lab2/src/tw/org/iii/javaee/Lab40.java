package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab40
 * 	20180929PM1
 */
@WebServlet("/Lab40")
public class Lab40 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int a = 0;
		while (true) {
			a = (int)(Math.random()*20+1);
			
			//	console 會看得到一直在執行
			System.out.println(a);
			
			//	out.print會出現嗎? 會, 不過是一次性的, 全部跑完再一次return
			out.println(a);
			
			//	==> 重點: 網頁的載入是一次性的
			
			if (a == 18) {
				out.println("Over!");
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println(e.toString());
				}
			}
		}
	}

}
