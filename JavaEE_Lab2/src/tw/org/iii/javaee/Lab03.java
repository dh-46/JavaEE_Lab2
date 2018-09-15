package tw.org.iii.javaee;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	20180902AM2
 * 	Servlet運作方式
 * 
 */
@WebServlet("/Lab03")
public class Lab03 extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 由service來判斷執行doGet or doPost
		//super.service(req, resp); // 會去呼叫 doGet
		System.out.println("service()");	// 第一次重啟時被呼叫
		doGet(req, resp); // 結果一樣是先呼叫service在呼叫doGet
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()");	// 有service時重啟自動沒出現, service註解後再重啟有自動出現
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("doPost()");
		//doGet(request, response); // doPost也交給doGet做
	}

}
