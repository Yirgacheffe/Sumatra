//: com.nsv.timentry.converter: DayConverter.java
package com.nsv.timentry.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nsv.timentry.constant.WeekDay;
import static com.nsv.timentry.constant.WeekDay.*;


/**
 * Convert enum Day type for table column like day 'TYPE'
 * 
 * @version 1.0.0 $ 2016-03-24 17:08 $
 */
@Converter( autoApply = true )
public class WeekDayConverter  implements AttributeConverter< WeekDay, String > {
    
    
    @Override
    public String convertToDatabaseColumn( WeekDay day ) {
        
        switch ( day ) {
            case HOLIDAY: return "H";
            case NORMAL:  return "N";
            case WEEKEND: return "W";
            
            default:
                throw new IllegalArgumentException( "Unknow WeekDay type: " +  day );
        }
        
    }

    @Override
    public WeekDay convertToEntityAttribute( String data ) {
        
        switch ( data ) {
            case "H": return HOLIDAY;
            case "N": return NORMAL;
            case "W": return WEEKEND;
            
            default:
                throw new IllegalArgumentException( "Unknow WeekDay data: " + data );
        }
        
    }
    
    
} //:~
