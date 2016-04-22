//: com.nsv.timentry.task: ReminderTaskManagerTest.java
package com.nsv.timentry.task;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;

import org.joda.time.LocalDate;

import org.junit.*;


/**
 * Test case of ReminderTaskManager, not sure what to test, just keep it
 *
 * @version 1.0.0 $ 2016-04-08 13:16 $
 */
public class ReminderTaskManagerTest {


    @Test
    public void testJodaTimeLocalDate() throws Exception {

        LocalDate today = new LocalDate();

        System.out.println( today.year().get()           );
        System.out.println( today.weekOfWeekyear().get() );
        System.out.println( today.weekyear().get()       );

    }

    @Test
    public void testLoadProperties() throws Exception {

        URL url = this.getClass().getResource( "/mail.properties" );

        Path path = Paths.get( url.toURI() );

        System.out.println( url );

        String real = MessageFormat.format( "Please submit your work log for {0}-{1}",  "2016", "14" );

        System.out.println( real );

    }


} //:~
