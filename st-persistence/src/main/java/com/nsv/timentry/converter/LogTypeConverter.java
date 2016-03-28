//: com.nsv.timentry.converter: LogTypeConverter.java
package com.nsv.timentry.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nsv.timentry.constant.LogType;
import static com.nsv.timentry.constant.LogType.*;


/**
 * Convert enum Log type for table column 'TYPE' in table 'LOG_ITEMS'
 * 
 * @version 1.0.0 $ 2016-03-26 16:25 $
 */
@Converter( autoApply = true )
public class LogTypeConverter implements AttributeConverter< LogType, Character > {
    
    
    @Override
    public Character convertToDatabaseColumn( LogType type ) {
        
        switch ( type ) {
            case OVERTIME: return 'O';
            case NORMAL:   return 'N';
            case SHIFT:    return 'S';
            case DAY_OFF:  return 'D';
            
            default:
                throw new IllegalArgumentException( "Unknow work item type: " + type );
        }
        
    }

    @Override
    public LogType convertToEntityAttribute( Character data ) {

        switch ( data ) {
            case 'O': return OVERTIME;
            case 'N': return NORMAL;
            case 'S': return SHIFT;
            case 'D': return DAY_OFF;
            
            default:
                throw new IllegalArgumentException( "Unknow work item type: " + data );
        }
        
    }
    
    
} //:~
