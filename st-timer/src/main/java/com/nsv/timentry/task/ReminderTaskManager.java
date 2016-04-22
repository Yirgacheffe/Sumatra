//: com.nsv.timentry.task: ReminderTaskManager.java
package com.nsv.timentry.task;

import java.util.Collection;
import java.util.Properties;
import java.text.MessageFormat;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.*;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.joda.time.LocalDate;

import com.nsv.timentry.service.WorkLogFacadeLocal;
import com.nsv.timentry.MailMessageSender;


/**
 * Collect all reminder tasks, currently not submit work log on time user will be reminded
 *
 * @version 1.0.0 $ 2016-04-08 13:08 $
 */
@Singleton
@Startup
@DependsOn( "WorklogService" )
public class ReminderTaskManager {


    private static final Logger logger = LoggerFactory.getLogger( ReminderTaskManager.class );

    @EJB
    private WorkLogFacadeLocal workLogFacade;

    @EJB
    private MailMessageSender  jmsMailSender;


    private static final Properties props = new Properties();

    @PostConstruct
    public void init() {
        try {
            props.load( getClass().getResourceAsStream("/mail.properties") );
        } catch ( IOException ex ) {
            logger.info( "Load property file mail.properties failed..", ex );
        }
    }


    /**
     * This task happened on every monday 12:00 midday, who is not submit their work log will
     * be reminded by email
     */
    @Schedule( dayOfWeek = "Mon", hour = "12" )
    public void sendMailCausedByWorkLogNotSubmit() {

        final LocalDate today = new LocalDate();

        int currYear = today.getYear();
        int lastWeek = today.getWeekOfWeekyear() - 1;

        // Recipient email list as String array then create map message
        String[] to = retrievalEmailsAsArray( currYear, lastWeek );

        if ( to == null || to.length == 0 ) {
            logger.info( "Email list is empty, now have a rest." );
            return;
        }

        // Content template
        String template = props.getProperty( "mail.content" );

        String content  = MessageFormat.format( template, Integer.toString( currYear ), lastWeek );
        String from     = props.getProperty( "mail.from"    );
        String subject  = props.getProperty( "mail.subject" );

        jmsMailSender.createMessageThenSend( from, to, subject, content  );

    }

    /**
     * Retrieval email address as array
     */
    private String[] retrievalEmailsAsArray( int year, int lastWeek ) {

        Collection<String> emails = workLogFacade.retrievalEmailsWhoNotSubmitWorkLog( year, lastWeek );
        return emails.toArray( new String[ emails.size() ] );

    }


} //:~
