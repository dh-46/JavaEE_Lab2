package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab44
 * 	0929PM1 非同步的程序如何進行
 * 
 */
@WebServlet(urlPatterns = "/Lab44", asyncSupported = true)
public class Lab44 extends HttpServlet {
	private ExecutorService excutorService = Executors.newFixedThreadPool(10);
	
	@Override
	public void init() throws ServletException {
		//	init => 裡面是一次性的
		
		super.init();
		
		System.out.println("Lab44_init()");
		
		ServletContext servletContext = getServletContext();
		
		//	準備資料結構 List 並把很多的任務放到List
		List<AsyncContext> asyncs = new LinkedList<>(); 
		servletContext.setAttribute("asyncs", asyncs);
		
		MyAsyncListener asyncListener = new MyAsyncListener();
		servletContext.setAttribute("asyncListener", asyncListener);
		
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		System.out.println("Lab44_doGet");
		
		//	把東西拿出來
		ServletContext servletContext = getServletContext();
		List<AsyncContext> asyncs = (List<AsyncContext>)servletContext.getAttribute("asyncs");
		
		MyAsyncListener asyncListener = (MyAsyncListener)servletContext.getAttribute("asyncListener");
		
		//	現在才要做事情
		AsyncContext async = request.startAsync();
		async.addListener(asyncListener);
		async.setTimeout(10*1000);
		
		asyncs.add(async);
		
		System.out.println("add a task");
		
		excutorService.execute(new AsyncRequest(async));
		
	}
	
	
	private class AsyncRequest implements Runnable {
		private AsyncContext asyncContext;
		
		public AsyncRequest(AsyncContext asyncContext) {
			this.asyncContext = asyncContext;
		}
		
		@Override
		public void run() {
			// 	非同步實作run方法
			//	裡面寫的是一次性的任務
			try {
				//	模擬做事情
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
}
