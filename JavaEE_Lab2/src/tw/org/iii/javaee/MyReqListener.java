package tw.org.iii.javaee;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/*
 * 	0929PM2 ServletRequestListener傾聽器
 * 	1.	實作ServletRequestListener介面
 * 	2.	Annotation => WebListener (一定要寫)
 * 	=> 被觸發後做甚麼事
 * 	=> 適合蒐集網站上的資訊
 * 	=> 整個Web容器就是個物件
 * 	Chpater 5
 */

@WebListener
public class MyReqListener implements ServletRequestListener{
	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("A Request...");
		ServletRequest req = sre.getServletRequest();
		String ip = req.getRemoteAddr();
		System.out.println("Remote IP: " + ip);
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("End Request");
	}
}
