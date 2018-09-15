package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	Servlet implementation class Lab22
 * 	20180908PM1 
 * 	帳號密碼驗證
 * 
 * 	> 把功能寫到類別檔中: servlet就呼叫他就好, 不用處理太多邏輯
 */
@WebServlet("/Lab22")
public class Lab22 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String p1 = "123456";
//		String p3 = "123456789";
//		String p2 = BCrypt.hashpw(p1, BCrypt.gensalt());
//		System.out.println("p1: " + p1);
//		System.out.println("p2: " + p2);
//		
//		System.out.println(BCrypt.checkpw(p3, p2));
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf8");
		PrintWriter writer = response.getWriter();
		
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");	// JAVA 專案裡面可以不加/ 但是JavaEE載入一定要加上
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/iii", "root", "root");
			
			String sql="SELECT * FROM `accounts` where account = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String src = rs.getString("password");
				if (LabAPI.checkPassword(src,password)) {
					//String realname = rs.getString("realname");
					// writer.println("Welcome, "+ realname);
					
					HttpSession session = request.getSession();
					Member member = new Member(rs.getString("realname"), rs.getString("account"), 18);
					session.setAttribute("member2", member);
					response.sendRedirect("Lab32");
				} else {
					//writer.println("Password Error");
					response.sendRedirect("lab22.html");
				}
			} else {
				// writer.println("Account not found!");
				response.sendRedirect("lab22.html");
			}
			
			
			System.out.println("OK");
		} catch (Exception e) {
			response.sendRedirect("lab22.html");
			System.out.println(e);
		}
		
		
	}

}
