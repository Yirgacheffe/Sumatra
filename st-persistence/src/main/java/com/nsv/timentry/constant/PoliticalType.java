//: com.nsv.timentry.entity: PoliticalType.java
package com.nsv.timentry.constant;


/**
 * Enumeration type for column 'POLITICAL_TYPE'
 * 
 * @version 1.0.0 $ 2016-03-25 16:02 $
 */
public enum PoliticalType {
    
    
    PARTY( 'P' ), LEAGUE( 'L' ), RESIDENCE( 'R' );
    
    // Single char used in DB
    private final char value;
    
    private PoliticalType( char v ) {
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
        return "Political type as String: [" + asString() + "]";
    }

    
} //:~
