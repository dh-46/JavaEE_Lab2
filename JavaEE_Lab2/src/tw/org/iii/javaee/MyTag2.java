package tw.org.iii.javaee;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;


/*
 * 	0929AM1 01:15:00
 * 
 */

public class MyTag2 extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		JspWriter out = getJspContext().getOut();
		
		//	取得JSP Body
		JspFragment body = getJspBody();
		
		//	利用StringWriter輸出
		StringWriter sw = new StringWriter();
		
		//	運用sw將整個body輸出 (資料在sw身上)
		body.invoke(sw);
		
		out.print("Hello, " + sw.toString().toUpperCase());
	}
}
