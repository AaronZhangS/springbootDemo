package org.springboot.statement.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.boot.web.servlet.server.Session;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailUtil implements Runnable {
	// 收件人邮箱
	private String email;
	// 激活码
	private String code;

	public MailUtil(String email, String code) {
		super();
		this.email = email;
		this.code = code;
	}

	@Override
	public void run() {
		// 1.创建连接对象javax.mail.Session
		// 2.创建邮件对象 javax.mail.Message
		// 3.发送一封激活邮件
			/*String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://localhost:8080/RegisterDemo/ActiveServlet?code="
					+ code + "'>http://localhost:8080/RegisterDemo/ActiveServlet?code=" + code
					+ "</href></h3></body></html>";*/
		
		
	}

}
