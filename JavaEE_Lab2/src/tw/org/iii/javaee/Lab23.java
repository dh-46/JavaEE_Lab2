package tw.org.iii.javaee;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab23\
 * 	20180908PM2
 * 	做個網頁繪圖板?!
 */
@WebServlet("/Lab23")
public class Lab23 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	宣告response輸出內容為影像資料
		response.setContentType("image/jpeg");
		
		String strRate = request.getParameter("rate");
		float rate = 0;
		
		try {
			rate = Float.parseFloat(strRate);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		//	建立繪圖元件<重點>
		BufferedImage bimg = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bimg.createGraphics();
				
		//	設定內容
		g2d.setColor(Color.YELLOW);
		g2d.fillRect(0, 0, bimg.getWidth(), bimg.getHeight());
		g2d.setColor(Color.RED);
		g2d.fillRect(0, 0, Math.round(bimg.getWidth()*(rate/100)), bimg.getHeight());
		
		
		
		//	response.getOutputStream() <重點>
		OutputStream out = response.getOutputStream();
		
		//	輸出
		ImageIO.write(bimg, "jpeg", out);
		out.flush();
		out.close();
		
	}

}
