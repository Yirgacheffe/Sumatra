//: com.nsv.timentry.enrity: Day.java
package com.nsv.timentry.entity;


/**
 * Enumeration type for column 'TYPE', in table NON_WORKINGDAY
 * 
 * @version 1.0.0 $ 2016-03-24 17:01 $
 */
public enum Day {
    
    
    NORMAL( 'N' ), WEEKEND( 'W' ), HOLIDAY( 'H' );
    
    
    // Single char used in DB
    private final char value;
    
    private Day( char v ) {
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
        return "Day type as String: [" + asString() + "]";
    }
    
    
} //:~
