package tw.org.iii.javaee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/*	
 * 	20180929PM2 SessionListener
 * 	1.	
 */

@WebListener
public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		//	連線建立的時候連線資料庫
		ServletContext servletContext = se.getSession().getServletContext();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");
			
			//	把連線的物件實體放到servletContext
			servletContext.setAttribute("conn", conn);
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// 連線結束後結束資料庫連線
		
	}

//	@Override
//	public void contextInitialized(ServletContextEvent sce) {
//		ServletContext servletContext = sce.getServletContext();
//		servletContext.setAttribute("key", "value");
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/iii", "root", "root");
//			
//			//	把連線的物件實體放到servletContext
//			servletContext.setAttribute("conn", conn);
//		
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	@Override
//	public void contextDestroyed(ServletContextEvent sce) {
//		//	servletContext連線結束 就把資料庫連線中斷
//	}

	
}
