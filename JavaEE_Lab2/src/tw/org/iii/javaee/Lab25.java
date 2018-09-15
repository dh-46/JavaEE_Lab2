package tw.org.iii.javaee;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	Servlet implementation class Lab25
 * 	20180908PM2
 * 	後端將上傳的圖片上浮水印
 * 	輸出畫面後同時儲存已上浮水印的圖片檔
 * 	
 * 	串流觀念整合!
 * 	
 * 	=> 對前端而言, 是可以取用來做變化
 */
@WebServlet("/Lab25")
public class Lab25 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpg");
		
		String uploadPath = getServletContext().getInitParameter("upload-dir");
		
		BufferedImage bimg = ImageIO.read(new File(uploadPath, "image.jpg"));
		Graphics2D g2d= bimg.createGraphics();
		
		Font font = new Font(null, Font.BOLD+Font.ITALIC, 80);
		
		// 文字旋轉
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(Math.random()*30), 40, 0);
		Font newFont = font.deriveFont(tran);
		
		//	圖檔加工
		g2d.setFont(newFont);
		g2d.setColor(Color.RED);
		g2d.drawString("LAB25", 1000, 1000);
		
		//	輸出
		OutputStream out = response.getOutputStream();
		File fileOut = new File(uploadPath, "lab25.jpg");
		ImageIO.write(bimg, "jpg", out);	// 螢幕上的輸出
		
		ImageIO.write(bimg, "jpg", fileOut);	//	檔案輸出
		out.flush();
		out.close();
	}


}
