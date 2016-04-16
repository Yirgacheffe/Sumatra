//: com.nsv.timentry.converter: BooleanConverter.java
package com.nsv.timentry.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


/**
 * Convert Boolean to Integer type for BIT(1) column
 *
 * @version 1.0.0 $ 2016-04-15 13:19 $
 */
@Converter( autoApply = true )
public class BooleanConverter implements AttributeConverter<Boolean, Integer> {


    @Override
    public Boolean convertToEntityAttribute( Integer dbData ) {
        return dbData > 0;
    }

    @Override
    public Integer convertToDatabaseColumn( Boolean boolVal ) {
        return boolVal ? 1 : 0;
    }


} //:~
