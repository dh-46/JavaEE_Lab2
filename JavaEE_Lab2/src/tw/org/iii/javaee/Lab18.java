package tw.org.iii.javaee;

/*	20180908AM2
 * 	for Lab17
 * 	負責處理邏輯
 */

public class Lab18 {
	int x, y;
	
	public Lab18(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
	public int add() {
		return x + y;
	}

}
