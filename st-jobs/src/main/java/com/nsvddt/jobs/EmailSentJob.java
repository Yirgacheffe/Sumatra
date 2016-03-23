package cn.com.nsv.ejb.job;

import java.util.Calendar;
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
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.com.nsv.ejb.conn.Config;
import cn.com.nsv.ejb.interfaces.WorklogService;
import cn.com.nsv.ejb.util.EjbService;

public class EmailSentJob implements Job {

	Logger logger = Logger.getLogger(EmailSentJob.class);
	
	EjbService ejbService = new EjbService();
	WorklogService worklogService = ejbService.getStub(Config.INNERINFO_IP
			+ ":" + Config.INNERINFO_JNDI_PORT, "innerInfoMgmt", "local",
			WorklogService.class);
	 

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			    System.out.println("发邮件了！");
			  
			    InitialContext ctx = new InitialContext();
	            Session mailSession = (Session) ctx.lookup("java:/Mail");
	            Calendar calendar = Calendar.getInstance();
	            calendar.setTime(new Date());
	            calendar.set(Calendar.DAY_OF_WEEK, 6);
	            Integer year = calendar.get(Calendar.YEAR);
	            Integer week = calendar.get(Calendar.WEEK_OF_YEAR);
	            week = week - 1;
	            List<String> emailList = worklogService.getNoSubmitWorklogEmailList(year, week);
	            for(int i = 0; i < emailList.size(); i++){
	            	try{
	            	MimeMessage m = new MimeMessage(mailSession);
	 	            Address[] to = new Address[] { new InternetAddress(emailList.get(i))};
	 	            m.setRecipients(Message.RecipientType.TO, to);
	 	            m.setSubject("请填报上周工作日志");
	 	            m.setSentDate(new Date());
	 	            m.setContent("请填报"+ year + "-" + week +"周工作日志"  ,
	 	                    "text/html;charset=utf-8");
	 	            Transport.send(m);
	            	}catch(Exception e){
	            		logger.error("发送单峰邮件出错：邮件地址："+ emailList.get(i) + " 错误 ： " +e.getClass());
	            	}
	            }
	           
		} catch (Exception e) {
			logger.error("发送邮件配置出错："+e.getClass());
			e.printStackTrace();
		}

	}
}
