// com.nsv.timentry.entity: ProjectStatus.java
package com.nsv.timentry.constant;


/**
 * Enumeration type for column 'STATUS' in table 'PROJECTS'
 * 
 * @version 1.0.0 $ 2016-03-26 12:45 $
 */
public enum ProjectStatus {

    
    STARTED( 'S' ), IN_PROGRESS( 'P' ), CLOSED( 'C' );
    
    
    // Char(1) used in DB, generally speaking converter will be used
    private final char value;
  
    private ProjectStatus( char v ) {
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
        return "ProjectStatus type as String: [" + asString() + "]";
    }
    
    
} //:~
