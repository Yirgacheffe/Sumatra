//: com.nsv.timentry.mdb: WorkLogReminderBean.java
package com.nsv.timentry.mdb;

import javax.ejb.MessageDriven;
import javax.ejb.ActivationConfigProperty;

import javax.annotation.Resource;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.JMSException;

import javax.mail.Session;

import com.nsv.timentry.PostOffice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Trying to send remind email to user who in the system are not finish their
 * work log submit on time
 *
 * @version 1.0.0 $ 2016-04-07 15:19 $
 */
@MessageDriven(
    activationConfig = {
        @ActivationConfigProperty( propertyName = "destinationName", propertyValue = "queue/WorkLogMailQueue" ),
        @ActivationConfigProperty( propertyName = "destinationType", propertyValue = "javax.jms.Queue" )
    },
    mappedName = "WorkLogReminderQueue"
)
public class WorkLogMailerBean implements MessageListener {


    private static final Logger logger = LoggerFactory.getLogger( WorkLogMailerBean.class );

    @Resource( name= "mail/timentryMail" )
    private Session mailSession;


    /**
     * Override parent method, only MapMessage is allowed, Json based
     * text message might be accepted in the future
     */
    @Override
    public void onMessage( Message message ) {

        if ( message == null ) {
            logger.info( "Received message is null, prepare the real message for sending." );
            return;
        }

        if ( message instanceof MapMessage ) {
            handleMapMessageThenSendMail( (MapMessage) message );
        } else {
            logger.info( "Only MapMessage is allowed, sorry!!" );
        }

    }


    /**
     * Get the values for mail sending from JMS MapMessage, recipient list could be string array
     * or just a string, represent multi user or just on user
     */
    private void handleMapMessageThenSendMail( MapMessage msg ) {

        try {

            String subject = msg.getString( "mail.subject" );
            String content = msg.getString( "mail.content" );

            Object to      = msg.getObject( "mail.to"   );
            String from    = msg.getString( "mail.from" );

            if ( to == null ) {
                logger.info( "Invalid value of mail.to, NULL is not allowed." );
                return;
            }

            // TODO: here we have some bug, you see it?
            if ( to instanceof String[] ) {
                PostOffice.sendMail(
                    mailSession, from, (String[]) to, subject, content );
            } else {
                PostOffice.sendMail(
                    mailSession, from, ( String ) to, subject, content );
            }

        } catch ( JMSException ex ) {
            logger.error("Error happened while get mail value from JMS MapMessage.", ex );
        }

    }


} //:~