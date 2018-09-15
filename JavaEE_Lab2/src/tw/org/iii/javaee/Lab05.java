package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*	20180902AM2 &PM1
 * 	試著處理lab04.html傳回來的要求
 * 	
 * 	用戶端(網頁)回傳方法: Post/ Get (後端由service方法判斷網頁端用哪招)
 * 	Get:
 * 		1. 傳送的參數會顯示在網址列
 * 	Post:
 * 		1. 傳送的參數不會顯示在網址列
 * 	
 * 	=> 靈魂人物: request & response
 */
@WebServlet("/Lab05")
public class Lab05 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		doTask(request, response, "get");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doTask(request, response, "post"); // 其實資訊就在request中
	}
	
	private void doTask(HttpServletRequest request, HttpServletResponse response, String method) throws ServletException, IOException {
		// 自訂方法 讓他彙整到這裡
		//System.out.println("doTask"+ method);
		
		// 網頁預設表現統一化
		response.setContentType("text/html; charset=UTF-8"); // 讓瀏覽器知道資料類型(務必在writer前先做)
		PrintWriter writer = response.getWriter();
		
		Enumeration<String> params = request.getParameterNames(); // 抓所有參數名稱 Parameter: 參數
		while (params.hasMoreElements()) {
			// 抓參數值
			String param = params.nextElement();
			String value = request.getParameter(param);
			String nvalue = new String(value.getBytes("ISO-8859-1"), "UTF8"); // 編碼轉換
			writer.append(param+" : "+ value +" : "+ nvalue + "<br>");
			/*	收到的中文字輸出後有亂碼	=>解決方案?
			 *	
			 *	先知道=>網路傳輸預設編碼是ISO8859-1 
			 *	
			 *	把輸入的資料轉換成byte陣列(設定為原始編碼)
			 *	再轉成需要的編碼字串
			 */
		}
		// 輸出
		writer.append("歡迎登入");
		writer.flush();
		
	}
}
