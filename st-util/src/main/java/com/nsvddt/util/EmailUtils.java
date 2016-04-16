package cn.com.nsv.ejb.util;

import java.util.Date;
import java.util.List;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.InitialContext;

import org.jboss.logging.Logger;

public final class EmailUtils {
	static Logger logger = Logger.getLogger(EmailUtils.class);
	
	public static void send(String subject, String content, List<String> recipients) {
		try {
			logger.info("开始发送邮件！");
		    InitialContext ctx = new InitialContext();
            Session mailSession = (Session) ctx.lookup("java:/Mail");
            for(int i = 0; i < recipients.size(); i++){
            	try{
	            	MimeMessage m = new MimeMessage(mailSession);
	 	            Address[] to = new Address[] { new InternetAddress(recipients.get(i))};
	 	            m.setRecipients(Message.RecipientType.TO, to);
	 	            m.setSubject(subject);
	 	            m.setSentDate(new Date());
	 	            m.setContent(content, "text/html;charset=utf-8");
	 	            Transport.send(m);
            	}catch(Exception e){
            		logger.error("发送邮件出错：邮件地址："+ recipients.get(i) + " 错误 ： " + e.getMessage());
            	}
            }
            logger.info("发送邮件结束！");
		} catch (Exception e) {
			logger.error("发送邮件配置出错："+e.getClass());
			e.printStackTrace();
		}
	}
}
