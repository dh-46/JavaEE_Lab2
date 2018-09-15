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
 * 	Servlet implementation class Lab12
 * 	20180908AM1 Dispatcher (分派/分支)
 * 	要知道中心點是哪個程式=> 例如在範例中 對使用者而言存取的是Lab12
 */
// @WebServlet("/JavaEE12.php")	//	括號內的參數為使用者端顯示的網址: 後期跟網站配置部屬有關
@WebServlet("/Lab12")
public class Lab12 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//	include Lab13到Lab12 (url夾帶參數name測試是否有傳到lab13)
		//	RequestDispatcher dispatcher1 = request.getRequestDispatcher("Lab13?name=john");
		
		String name = request.getParameter("name");	// 
		
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("Lab13?name=allen"); 
		// 測試看看Url中的參數lab12/13各自接收的狀況
		//	dispatcher的修改影響到的是lab13
		
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("lab10.html");
		
		out.println("<h1>Lab12_20180908AM1</h1>");
		out.println("This is Lab12:" + name);
		out.print("<hr>");
		
		// add Lab13 (可獨立邏輯出來, )
		/*	Lab12的參數物件 (request, response)透過dispatcher傳給Lab13
		 * 	=> 相同的物件實體傳遞
		 * 
		 */
		dispatcher1.include(request, response);
		
		out.println("<hr>");
		
		dispatcher2.include(request, response);
		// out.flush();
	}


}
