package tw.org.iii.javaee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab45
 * 	0929PM2 for SessionListener連線資料庫
 * 	
 * 	實務上可視情況將連線做在不同層級
 */
@WebServlet("/Lab45")
public class Lab45 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		ServletContext servlectContext = request.getSession().getServletContext();
		
		try {
			Connection conn = (Connection)servlectContext.getAttribute("conn");
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `cust`(name, tel, birthday) VALUES ('John2', '123456','2018-09-29')";
			stmt.executeUpdate(sql);
			System.out.println("Insert OK");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
