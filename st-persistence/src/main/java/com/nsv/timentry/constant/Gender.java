//: com.nsv.timentry.enrity: Gender.java
package com.nsv.timentry.constant;


/**
 * Enumeration type for column 'GENDER'
 * 
 * @version 1.0.0 $ 2016-03-24 13:02 $
 */
public enum Gender {
    
    
    FEMALE( 'F' ), MALE( 'M' ), OTHERS( 'O' );
    
    
    // Single char used in DB
    private final char value;
    
    private Gender( char v ) {
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
        return "Gender type as String: [" + asString() + "]";
    }
    
    
} //:~
