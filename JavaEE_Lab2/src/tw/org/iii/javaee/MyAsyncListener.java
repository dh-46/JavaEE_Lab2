package tw.org.iii.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;


/*	20180929PM1
 * 	非同步的傾聽器
 * 	
 * 	閱讀 Chapter5
 */


public class MyAsyncListener implements AsyncListener{
	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("onComplete");
		
		AsyncContext asyncContext = event.getAsyncContext();
		PrintWriter out = asyncContext.getResponse().getWriter();
		
		List<AsyncContext> asyncs = 
				(List<AsyncContext>)asyncContext.getRequest().getServletContext().getAttribute("asyncs");
		
		int i = asyncs.indexOf(asyncContext);
		
		// asyncs.remove(asyncContext);
		
		out.println(i + " : " + (int)(Math.random()*49+100));
	}
	
	

	

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("onError");
		
		AsyncContext asyncContext = event.getAsyncContext();
		List<AsyncContext> asyncs = 
				(List<AsyncContext>)asyncContext.getRequest().getServletContext().getAttribute("asyncs");
		asyncs.remove(asyncContext);
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("onStartAsync");
	}
	

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("onTimeout");
		
		AsyncContext asyncContext = event.getAsyncContext();
		List<AsyncContext> asyncs = 
				(List<AsyncContext>)asyncContext.getRequest().getServletContext().getAttribute("asyncs");
		asyncs.remove(asyncContext);
	}
	
}
