package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lab01
 */
@WebServlet("/Lab01")
public class Lab01 extends HttpServlet {
	// private static final long serialVersionUID = 1L;	// 版本控制用
       
    /** see: 參考的意思
     * @see HttpServlet#HttpServlet()
     */
	
	private static int a;
	private int b;
    public Lab01() {
    	System.out.println("Lab01"); // 只是讓人了解物件建構
    	// 當Server啟動就產生這個物件實體, 全世界就這一個物件實體.
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");
		
		PrintWriter pw = response.getWriter();
		pw.append("<h1>Hello, world!</h1><br>"); // 輸出HTML/JS
		pw.append("<a href='http://www.google.com' target='_Blank'>Google</a><br>");
		pw.append("a = " + a++ + "<br>"); // 數字的狀態是在後端
		pw.append("b = " + b++ + "<br>"); // 兩個結果是一樣的 => 因為只有一個物件實體
		pw.flush(); // 記憶體內沖出
		
//		response.getWriter()
//				.append("Served @: ")
//				.append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
