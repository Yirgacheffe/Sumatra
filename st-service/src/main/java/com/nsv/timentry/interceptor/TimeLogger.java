//: com.nsv.timentry.interceptor: TimeLogger.java
package com.nsv.timentry.interceptor;

import javax.interceptor.InvocationContext;
import javax.interceptor.Interceptor;
import javax.interceptor.AroundInvoke;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
    

/**
 * TimeLogger interceptor trying to log the execution time in millisecond
 * 
 * @version 1.0.0 $ 2016-03-29 10:16 $
 */
@Interceptor
public final class TimeLogger {

    
    private static final Logger logger = LoggerFactory.getLogger( TimeLogger.class );
    
    @AroundInvoke
    public Object TimerLog( InvocationContext ctx ) throws Exception {
        
        String businessClassName = ctx.getClass().getName();
        String methodName = ctx.getMethod().getName();
        
        String target = businessClassName + "." + methodName;        
        long startTime = System.currentTimeMillis();
        
        logger.info( "Invoking "   + target );
        
        try {
            return ctx.proceed();
        } finally {
            long totalTime = System.currentTimeMillis() - startTime;
            logger.info( methodName + " in " + businessClassName + " takes " + totalTime + "ms to execute." );
            logger.info( "Ending " + target );
        }
        
    }

    
} //:~
