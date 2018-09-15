package tw.org.iii.javaee;
/*	20180909AM2 for Lab31
 * 
 */
public class Member {
	private String name;
	private int age;
	private String account;
	public Member(String name, String account, int age) {
		this.name = name;
		this.age = age;
		this.account = account;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAccount() {
		return account;
	}
}
