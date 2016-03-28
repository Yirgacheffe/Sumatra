//: com.nsv.timentry.converter: GenderConverter.java
package com.nsv.timentry.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nsv.timentry.constant.Gender;
import static com.nsv.timentry.constant.Gender.*;


/**
 * Convert enum Gender type for table column 'GENDER'
 * 
 * @version 1.0.0 $ 2016-03-24 13:30 $
 */
@Converter( autoApply = true )
public class GenderConverter implements AttributeConverter< Gender, String > {

    
    @Override
    public String convertToDatabaseColumn( Gender gender ) {
        
        switch ( gender ) {
            case FEMALE: return "F";
            case MALE:   return "M";
            case OTHERS: return "O";
            
            default:
                throw new IllegalArgumentException( "Unknow Gender type: " + gender );
        }
        
    }

    @Override
    public Gender convertToEntityAttribute( String dbData ) {
        
        switch ( dbData ) {
            case "F": return FEMALE;
            case "M": return MALE;
            case "O": return OTHERS;
            
            default:
                throw new IllegalArgumentException( "Unknow Gender data: " + dbData );
        }
        
    }
    
    
} //:~
