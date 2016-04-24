//: cm.nsv.timentry.task: MailMessageSender.java
package com.nsv.timentry;

import javax.inject.Inject;
import javax.annotation.Resource;

import javax.ejb.*;
import javax.jms.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Compose JMS map message for mail sending, might be related worklog reminder
 * and password reset
 *
 * @version 1.0.0 $ 2016-04-19 15:51 $
 */
@Singleton
@Startup
public class MailMessageSender {


    private static final Logger logger = LoggerFactory.getLogger( MailMessageSender.class );

    public static final String FROM, TO, CONTENT, SUBJECT;

    static {
        FROM    = "mail.from";
        TO      = "mail.to";
        CONTENT = "mail.content";
        SUBJECT = "mail.subject";
    }

    // TODO: lookup name not correct
    @Inject
    @Resource( lookup = "java/xyz/ConnectionFactory" )
    private JMSContext context;

    @Resource( lookup = "queue/WorkLogEmailQueue" )
    private Queue queue;


    /**
     * Compose the map message then send to queue
     */
    public void createMessageThenSend( String from, String   to, String subject,
                                       String content ) {

        createMessageThenSend( from, new String[] { to }, subject, content );
    }


    /**
     * Compose the map message then send to queue
     */
    public void createMessageThenSend( String from, String[] to, String subject,
                                       String content ) {

        MapMessage msg = context.createMapMessage();

        try {
            msg.setString( FROM,    from    );
            msg.setObject( TO,      to      );
            msg.setString( SUBJECT, subject );
            msg.setString( CONTENT, content );

        } catch ( JMSException ex ) {
            logger.error( "Error happened when create mail message......", ex );
        }

        context.createProducer().send( queue, msg );

    }


} //:~
