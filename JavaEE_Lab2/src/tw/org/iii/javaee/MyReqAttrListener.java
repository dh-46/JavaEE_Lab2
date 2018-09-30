package tw.org.iii.javaee;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/*	20180929PM2 Attribute Listener
 * 	1.	實作ServletRequestAttributeListener
 * 	2.	一樣要加上Annotation才可使用
 * 	
 */

//	干擾0930AM1 先註解
//	@WebListener
public class MyReqAttrListener implements ServletRequestAttributeListener{

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		String key = srae.getName();
		String value = (String)srae.getValue();
		System.out.println("Add: " + key + " = " + value);
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		String key = srae.getName();
		String value = (String)srae.getValue();
		System.out.println("Remove: " + key + " = " + value);
		
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		String key = srae.getName();
		Object value = srae.getValue().toString();
		System.out.println("Replace: " + key + " = " + value);
		
	}
	
}
