package org.springboot.statement.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
		
		// 服务器地址:
		String smtp = "smtp.qq.com";
		// 登录用户名:
		String username = "1164968903@qq.com";
		// 登录口令:
		String password = "orfvgbdpacekghcg";
		// 连接到SMTP服务器587端口:
		Properties props = new Properties();
		props.put("mail.smtp.host", smtp); // SMTP主机名
		props.put("mail.smtp.port", "587"); // 主机端口号
		props.put("mail.smtp.auth", "true"); // 是否需要用户认证
		props.put("mail.smtp.starttls.enable", "true"); // 启用TLS加密
		// 获取Session实例，导包javax.mail.Session;:
		Session session = Session.getInstance(props, new Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});
		// 设置debug模式便于调试:
		session.setDebug(true);
		try {
			MimeMessage message = new MimeMessage(session);
			// 设置发送方地址:
			message.setFrom(new InternetAddress("1164968903@qq.com"));
			// 设置接收方地址:
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
			// 设置邮件主题:
			message.setSubject("账号激活", "UTF-8");
			// 设置邮件正文:
			// message.setText("Hi Xiaoming...", "UTF-8");
			String content = "<html><head></head><body><h1>这是一封激活邮件,激活请点击以下链接</h1><h3><a href='http://106.13.130.77:8080/regist/verified?code="
			+ code + "'>http://106.13.130.77:8080/regist/verified?code=" + code
			+ "</href></h3></body></html>";
			message.setContent(content, "text/html;charset=UTF-8");
			// 发送:
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("发送失败！！！");
		}
	}

}
