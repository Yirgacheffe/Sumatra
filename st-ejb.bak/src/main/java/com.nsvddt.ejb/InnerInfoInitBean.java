package cn.com.nsv.ejb.bean;

import java.util.Date;
import org.jboss.ejb3.annotation.Management;
import org.jboss.ejb3.annotation.Service;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;
import cn.com.nsv.ejb.interfaces.InnerInfoInit;
import cn.com.nsv.ejb.job.EmailSentJob;

@Service
@Management(InnerInfoInit.class)
public class InnerInfoInitBean implements InnerInfoInit{

	@Override
	public void start() {
		Scheduler sched = null;
		try {
			
			sched = StdSchedulerFactory.getDefaultScheduler();
			CronTrigger emailSentHandleTrigger = new CronTrigger("emailSentHandleTrigger", "alwaysTrigger", "emailSentJob", "alwaysJob",
						"0 0 12 ? * 2 *");
			JobDetail emailSentJob = new JobDetail("emailSentJob", "alwaysJob", EmailSentJob.class);
			emailSentHandleTrigger.setStartTime(new Date());
			sched.addJob(emailSentJob, true);
            sched.scheduleJob(emailSentHandleTrigger);
            sched.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
