package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *	Servlet implementation class Lab42
 *	0929PM1 結束41的Timer/TimerTask
 *	瀏覽器等伺服器端回應	=> 同步
 *	
 */
@WebServlet("/Lab42")
public class Lab42 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//	取得41的timer然後結束他
//		HttpSession session = request.getSession();
//		Timer timer = (Timer)session.getAttribute("timer");
//		timer.cancel();
//		timer.purge();
//		timer = null;
//		session.invalidate();
		
		
		HttpSession session = request.getSession();
		
		Lab41.MyTask task1 = (Lab41.MyTask)session.getAttribute("task1");
		Lab41.MyTask2 task2 = (Lab41.MyTask2)session.getAttribute("task2");
		
		if (task1 == null && task2 != null) {
			task2.cancel();
			task2 = null;
			session.removeAttribute("task2");
		} else if (task1 != null){
			task1.cancel();
			task1 = null;
			session.removeAttribute("task1");
		} else {
			out.println("No more tasks!");
			session.invalidate();
		}
		
		
		
	}

}
