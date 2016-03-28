//: com.nsv.timentry.entity: LogStatus.java
package com.nsv.timentry.constant;


/**
 * Enumeration type for column 'STATUS' in table 'WEEK_LOGS' and 'DAY_LOGS'
 * 
 * @version 1.0.0 $ 2016-03-26 13:10 $
 */
public enum LogStatus {

    
    CREATED( 'C' ), SUBMITTED( 'S' ), REJECTED( 'R' ), PERMITTED( 'P' );
    
    
    // Single char used in DB, type converter will be used often
    private final char value;
    
    private LogStatus( char v ) {
        this.value = v;
    }
    
    public String asString() {
        return Character.toString( value );
    }
    
    public char value() {
        return value;
    }
    
    
    @Override
    public String toString() {
        return "Log status type as String: [" + asString() + "]";
    }
    
    
} //:~
