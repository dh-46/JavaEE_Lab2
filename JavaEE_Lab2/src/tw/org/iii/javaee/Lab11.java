package tw.org.iii.javaee;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/*	20180902PM2 檔案上傳處理
 * 	
 * 	1.	權限的觀念
 * 	2.	檔案目錄的設定(C:\Users\Daniel\git\JavaEE_Lab\JavaEE_Lab\WebContent\Upload)
 * 		建立&設定xml檔案: WEB-INF/web.xml
 * 	3.	annotation for 	@MultipartConfig
 */

@WebServlet("/Lab11")
@MultipartConfig
public class Lab11 extends HttpServlet {
	

	// 因為是處理檔案, 可不寫doGet
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
		String uploadPath = context.getInitParameter("upload-dir"); // 抓取初始的設定值 (xml)
		System.out.println(uploadPath);
		
		Part upload = request.getPart("upload");
		Collection<String> headerNames = upload.getHeaderNames();
		for (String name : headerNames) {
			String value = upload.getHeader(name);
			System.out.println(name + " : "+ value);
		}
		System.out.println("-----");
		long size = upload.getSize();
		System.out.println("File size: " + (size/1024));
		String fileName = upload.getSubmittedFileName();
		System.out.println(fileName);
		
		String status;
		
		
		try {
			InputStream in = upload.getInputStream();
			BufferedInputStream bin = new BufferedInputStream(in);
			
			byte[] buf = in.readAllBytes(); // Java 9 之後
			bin.close();
			
			FileOutputStream fout = new FileOutputStream(new File(uploadPath, fileName));
			fout.write(buf);
			fout.flush();
			fout.close();
			status = "OK";
			System.out.println("OK");
			PrintWriter writer = response.getWriter();
			writer.append("Status: " + status);
		} catch (Exception e) {
			System.out.println(e);
			status = e.toString();
		}
		
	}

}
