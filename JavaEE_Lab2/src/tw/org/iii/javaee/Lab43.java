package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Lab43 
 * 0929PM1 非同步
 * 1. 定義非同步的任務
 * 
 * 	補充: 手機推播的延遲回應
 * 	讓使用者的要求等待, 有事件時再傳回
 */

//	Annotation要宣告
@WebServlet(urlPatterns = "/Lab43",
			asyncSupported=true
		)
public class Lab43 extends HttpServlet {
	//	開一個線程
	private ExecutorService executorService = Executors.newFixedThreadPool(1);
	AsyncContext asyncContext;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//	response是同步輸出
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		asyncContext = request.startAsync();
		executorService.execute(new AsyncRequest());
		
		//	out.println("Lab43 OK");
		//	System.out.println("Lab43 OK");
		out.println("end");
	}
	
	private class AsyncRequest implements Runnable {
		@Override
		public void run() {
			// 	非同步實作run方法
			//	裡面寫的是一次性的任務
			try {
				Thread.sleep(10*1000);
				
				PrintWriter out = asyncContext.getResponse().getWriter();
				int rand = (int)(Math.random()*49+1);
				out.println("OK: " + rand);
				asyncContext.complete();
			} catch (InterruptedException e) {
				System.out.println(e.toString());
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy");
		
		//	關閉線程
		executorService.shutdown();
		super.destroy();
	}

}
