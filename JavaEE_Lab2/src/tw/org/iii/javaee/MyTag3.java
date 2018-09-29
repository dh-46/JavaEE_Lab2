package tw.org.iii.javaee;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*
 * 	0929AM1 01:30:54
 * 	自訂標籤
 * 	帶入參數
 * 	
 */

public class MyTag3 extends SimpleTagSupport{
	//	若把標籤看成一個物件, 其屬性就是物件的屬性
	//	存取修飾設為private => 要透過getter/setter
	private String itemName;
	private String price;
	private StringWriter sw;
	
	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		
		//	輸出
		JspWriter out = getJspContext().getOut();
		// out.print(itemName + ": " + price);
		
		//	use Body
		sw = new StringWriter();
		getJspBody().invoke(sw);
		//	寫出
		out.write( itemName + " : "+ price + " => " +sw.toString() + "<br>");
	}
	
	//	setter
	public void setitemName(String itemName) {
		this.itemName = itemName;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
}
