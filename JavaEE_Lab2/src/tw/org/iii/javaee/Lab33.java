package tw.org.iii.javaee;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *	Servlet implementation class Lab33
 *	20180909AM2 細看servlet運作模式
 *	
 *	
 */
@WebServlet(
		urlPatterns = {"/Lab33","/iii/2001"}, // 對外宣告的網址
		initParams = { // init參數 (適合開發階段的初始設定)
				@WebInitParam(name="x", value="10"),
				@WebInitParam(name="y", value="3"),
		}
		)
public class Lab33 extends HttpServlet {
	private ServletConfig servletConfig;
	private ServletContext servletContext;
	
	public Lab33() {
		super();
		System.out.println("Lab33()");
	}
	
	@Override
	public void init() throws ServletException {
		//	
		
		servletConfig = getServletConfig();
		servletContext = getServletContext();
		
		// 在init就可以抓到/ 不用每次都到doGet時候才抓
		String uploadPath = servletContext.getInitParameter("upload-dir");
		System.out.println(uploadPath);
		
		String x = servletConfig.getInitParameter("x");
		String y = servletConfig.getInitParameter("y");
		System.out.println(x + y);
		
		String rootPath = servletContext.getRealPath("/"); 	// 根目錄的真實路徑
		Set<String> resourcePath = servletContext.getResourcePaths("/"); 	// resource 根目錄
		
		System.out.println("root: " + rootPath);
		
		for (String paths : resourcePath) {
			System.out.println(paths);
		}
		
		System.out.println("init()");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service");
		super.service(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
	}

}
