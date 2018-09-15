package tw.org.iii.beans;

/*
 * 	20180915AM2
 * 	
 */

public class labAPIs {
	public static String lottery() {
		int rand = (int)(Math.random()*49+1);
		return rand+"";
	}
	
	public static String sayHi(String name) {
		return "Hello, " + name + "!";
	}
	
	public static String toIntString(double v) {
		Double d = v;
		d.intValue();
		
		return d.intValue() + "";
	}
}
