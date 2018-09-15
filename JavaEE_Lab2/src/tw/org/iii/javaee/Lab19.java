package tw.org.iii.javaee;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab19
 * 	20180908AM2 
 * 
 */
@WebServlet("/Lab19")
public class Lab19 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String result = request.getParameter("result");
		
		try {
			String htmlFile = loadTempView("mycal2.html");
			// String.format() 
			// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#format(java.lang.String,%20java.lang.Object...)
			String outHtml = String.format(htmlFile, x, y, result);
			out.print(outHtml);
			out.flush();
		} catch (Exception e) {
			out.println("Server Busy");
			System.out.println(e.toString());
		}
		
	}
	
	private String loadTempView(String fileName) throws Exception {
		//	取得路徑
		String tempPath = getServletContext().getInitParameter("temp-dir");
		//	載入檔案
		File viewFile = new File(tempPath, fileName);
		
		// 方法一: (會保留換列符號)
//		byte[] buf = new byte[(int)(viewFile.length())];
//		
//		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(viewFile));	// 例外讓外面處理
//		bin.read(buf);
//		bin.close();
//		return new String(buf);
		
		//	方法二: Reader (可去除換列符號)
		BufferedReader reader = new BufferedReader(new FileReader(viewFile));
		StringBuffer sb = new StringBuffer();
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		
		return sb.toString();
	}

}
