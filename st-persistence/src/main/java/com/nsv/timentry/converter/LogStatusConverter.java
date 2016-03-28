//: com.nsv.timentry.converter: LogStatusConverter.java
package com.nsv.timentry.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nsv.timentry.constant.LogStatus;
import static com.nsv.timentry.constant.LogStatus.*;


/**
 * Convert enum week log and day log status for table column 'STATUS'
 * 
 * @version 1.0.0 $ 2016-03-26 13:22 $
 */
@Converter( autoApply = true )
public class LogStatusConverter implements AttributeConverter< LogStatus, Character > {

    
    @Override
    public Character convertToDatabaseColumn( LogStatus status ) {
        
        switch ( status ) {
            case CREATED:   return 'C';
            case SUBMITTED: return 'S';
            case REJECTED:  return 'R';
            case PERMITTED: return 'P';
            
            default:
                throw new IllegalArgumentException( "Unknow Log status: " + status );
        }
        
    }

    @Override
    public LogStatus convertToEntityAttribute( Character dbChar ) {
        
        switch ( dbChar ) {
            case 'C': return CREATED;
            case 'S': return SUBMITTED;
            case 'R': return REJECTED;
            case 'P': return PERMITTED;
            
            default:
                throw new IllegalArgumentException( "Unknow Log status: " + dbChar );
        }
    }
    

}//:~
