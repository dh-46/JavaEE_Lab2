package tw.org.iii.javaee;

public class LabAPI {
	public static boolean checkPassword(String src, String cPassword) {
		boolean isRight = false;
		
		if (src.startsWith("$2a$10$")) {
			isRight = BCrypt.checkpw(cPassword, src);
		}
		
		return isRight;
	}
}
