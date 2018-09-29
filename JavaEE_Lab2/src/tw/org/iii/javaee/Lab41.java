package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	Servlet implementation class Lab41
 * 	20180929PM1 Servlet有支援Timer嗎?
 * 	
 * 	=> 應用: 遠端控制伺服器的關鍵動作?
 * 	=> 通常是針對資料庫操作
 */
@WebServlet("/Lab41")
public class Lab41 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		Timer timer = new Timer();
		MyTask task1 = new MyTask();
		MyTask2 task2 = new MyTask2();
		timer.schedule(task1, 0, 1*1000);
		timer.schedule(task2, 0, 2*1000);
		//	把timer放到session中
		HttpSession session = request.getSession();
		session.setAttribute("timer", timer);
		session.setAttribute("task1", task1);
		session.setAttribute("task2", task2);
		
		// 有印出, 但是Timer仍持續在伺服器的背景運作
		out.println("End");
	}
	
	class MyTask extends TimerTask {
		@Override
		public void run() {
			System.out.println("1: " + (int)(Math.random()*49+1));
		}
	}
	
	class MyTask2 extends TimerTask {
		@Override
		public void run() {
			System.out.println("2: " + (int)(Math.random()*49+1));
		}
	}
	
}
