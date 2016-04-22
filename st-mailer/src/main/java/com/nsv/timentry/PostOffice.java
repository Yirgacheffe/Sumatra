//: com.nsv.timentry: PostOffice.java
package com.nsv.timentry;

import java.util.Date;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.MessagingException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * When the lovely postman arrived, you know that you mail is coming.
 * who wrote that mail to you? And what's the content on the mail? Just open it then read...
 *
 * @version 1.0.0 $ 2016-04-07 17:00 $
 */
public final class PostOffice {


    private static final Logger logger = LoggerFactory.getLogger( PostOffice.class );

    private static PostOffice instance = new PostOffice();
    private PostOffice() {
        // Everybody knows that this is simple singleton pattern
    }

    public static PostOffice getInstance() {
        return instance;
    }

    /**
     * Sending mail to multi-user
     */
    public static void sendMail( Session session, String from, String[] to,
                                 String  subject,
                                 String  content ) {

        if ( to == null ) {
            logger.info( "Invalid recipient address: Null" );
            return;
        }

        for ( String address : to ) {
            PostOffice.sendMail( session, from, address, subject, content );
        }

    }

    /**
     * Send mail to one person
     */
    public static void sendMail( Session session, String from, String to, String subject,
                                 String  content ) {

        // isBlank() will handle all things, refer the apache api will help
        if ( StringUtils.isBlank( to ) ) {
            logger.info( "Invalid recipient address: {}", to );
            return;
        }

        try {
            Message mailMsg = new MimeMessage( session );

            mailMsg.setFrom( new InternetAddress(from) );
            mailMsg.setRecipient( javax.mail.Message.RecipientType.TO, new InternetAddress(to) );
            mailMsg.setSubject( subject );
            mailMsg.setContent( content, "text/html;charset=utf-8" );

            mailMsg.setSentDate( new Date() );

            logger.info( "Start sending email to: {} ", to );
            Transport.send( mailMsg );
            logger.info( "Sending  successful to: {} ", to );

        } catch ( MessagingException ex ) {
            logger.error(
                "Error happen while sending mail to {}, error {}.", new Object[] { to, ex } );
        }

    }


} //:~
