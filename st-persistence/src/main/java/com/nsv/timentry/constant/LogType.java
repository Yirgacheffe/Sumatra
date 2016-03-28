//: com.nsv.timentry.entity: LogType.java
package com.nsv.timentry.constant;


/**
 * Enumeration type for column 'TYPE' in table 'LOG_ITEMS'
 * 
 * @version 1.0.0 $ 2016-03-26 13:10 $
 */
public enum LogType {
    
    
    NORMAL( 'N' ), OVERTIME( 'O' ), DAY_OFF( 'D' ), SHIFT( 'S' );
    
    
    // Single char used in DB, type converter will be used often
    private final char value;
    
    private LogType( char v ) {
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
        return "Log item type as String: [" + asString() + "]";
    }
    
    
} //:~
