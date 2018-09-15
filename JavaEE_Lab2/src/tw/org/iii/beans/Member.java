package tw.org.iii.beans;

import java.io.Serializable;

/*
 *	Java Bean
 * 	1.	必須是 public class
 * 	2.	implements Serializable	(新的版本可以不做, 但建議仍做序列化)
 * 	3.	all fields not a public => private (實現封裝) [屬性如果設成public仍可以執行, 但有安全性疑慮]
 * 	4.	default constructor 預設建構式(無傳參數建構式)
 * 	5.	會有 getter & setter => getXXX()/setXXX()
 * 
 * 	JSP標籤所使用的物件必須符合上述條件
 */

//public class Member implements Serializable{
public class Member {
	// 屬性命名全小寫
	private String id, name;
	
	public Member() {
		
	}
	
	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return name + id;
	}
}
