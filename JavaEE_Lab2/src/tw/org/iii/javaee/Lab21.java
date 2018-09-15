package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab21
 * 	20180908PM1 連接資料庫
 * 	=> 帳號註冊
 * 	=> 
 * 	
 * 	
 */
@WebServlet("/Lab21")
public class Lab21 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//	開發階段開啟doGet轉至doPost做
		//	開發完成後將doGet裡的doPost註解	=> 讓使用者無法使用doGet
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String realname = request.getParameter("realname");
		
		
		//	確認都有拿到值
		out.println("Account: "+account);
		out.println("Password: "+password);
		out.println("Real Name: "+realname);
		out.println("<hr>");
		
		//	密碼的編碼處理: 避免明碼	=> BCrypt
		password = BCrypt.hashpw(password, BCrypt.gensalt());
		out.println("Hashed Password: " + password);
		out.println("Hashed Length: " + password.length());
		
		//	確認密碼是否正確
		//	boolean a = BCrypt.checkpw(password, password2);
		//	out.println("True/False: " + a);
		
		testMySQL(account, password, realname);
	}
	
	private void testMySQL(String account, String password, String realname) {
		try {
			Class.forName("com.mysql.jdbc.Driver");	// JAVA 專案裡面可以不加/ 但是JavaEE載入一定要加上
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii", "root", "root");
			
			String sql="INSERT INTO `accounts` (account, password, realname) VALUES (?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			pstmt.setString(3, realname);
			pstmt.executeUpdate();
			
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
}
