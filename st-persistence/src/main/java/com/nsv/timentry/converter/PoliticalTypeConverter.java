//: com.nsv.timentry.converter: PoliticalTypeConverter.java
package com.nsv.timentry.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nsv.timentry.constant.PoliticalType;
import static com.nsv.timentry.constant.PoliticalType.*;


/**
 * Convert enum Political type for table column 'POLITICAL_TYPE'
 * 
 * @version 1.0.0 $ 2016-03-24 16:07 $
 */
@Converter( autoApply = true )
public class PoliticalTypeConverter implements AttributeConverter<PoliticalType, String> {
    
    
    @Override
    public String convertToDatabaseColumn( PoliticalType pType ) {
        
        switch ( pType ) {
            case RESIDENCE: return "R";
            case PARTY:     return "P";
            case LEAGUE:    return "L";

            default:
                throw new IllegalArgumentException( "Unknow Political type: " + pType );
        }
        
    }

    @Override
    public PoliticalType convertToEntityAttribute( String dbData ) {
        
        switch ( dbData ) {
            case "R": return RESIDENCE;
            case "P": return PARTY;
            case "L": return LEAGUE;
            
            default:
                throw new IllegalArgumentException( "Unknow Political data: " + dbData );
        }
        
    }
    
    
} //:~
