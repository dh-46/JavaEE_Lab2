<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@page import="javax.mail.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lab86_JavaMail</title>
</head>
<body>
<%
	// 運用Google發信
	final String username="xxx@gmail.com";
	final String password="xxxxxx";
	
	Properties props = new Properties();
	//	props.put("mail.smtp.auth", "true");
	//	props.put("mail.smtp.host", "smtp.gmail.com");
	//	props.put("mail.smtp.post","587");
	//	props.put("mail.smtp.starttls.enable","true");
	
	props.put("mail.smtp.host", "ms7.hinet.net");
	// 有個隱含物件session 注意命名!
	// mailing session
	//	SMTP 原理: 
		// 一連串的通訊動作(非一次性) ==> one session
		// port: 25
	//Session sessionMail = Session.getInstance(props, 
	//		new Authenticator() {
	//	protected PasswordAuthentication getPasswordAuthentication() {
	//		return new PasswordAuthentication(username, password);
	//	}
	//});
	
	Session sessionMail = Session.getInstance(props);
	
	try {
		//	send data(mail content)
		//	**telnet cannot send mails with files
		//	**mime can send mails with files (newer)
		Message message = new MimeMessage(sessionMail);
		//	Addreass => send from?
		message.setFrom(new InternetAddress("sender@gmail.com"));
		//	send to one person / Addreass => who do you want to send?
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("receiver@gmail.com"));
		//	mail text
		message.setText("Hello!\n");
		//	mail subject
		message.setSubject("Hello from sender");
		
		Transport.send(message);
		out.println("send OK");
	} catch (Exception e) {
		out.println(e.toString());
	}
	
%>
</body>
</html>