//: com.nsv.timentry.enrity: Day.java
package com.nsv.timentry.constant;


/**
 * Enumeration type for column 'TYPE', in table NON_WORKINGDAY
 * 
 * @version 1.0.0 $ 2016-03-25 17:01 $
 */
public enum WeekDay {
    
    
    NORMAL( 'N' ), WEEKEND( 'W' ), HOLIDAY( 'H' );
    
    
    // Single char used in DB
    private final char value;
    
    private WeekDay( char v ) {
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
        return "WeekDay type as String: [" + asString() + "]";
    }
    
    
} //:~
