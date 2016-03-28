//: com.nsv.timentry.converter: ProjectStatusConverter.java
package com.nsv.timentry.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.nsv.timentry.constant.ProjectStatus;
import static com.nsv.timentry.constant.ProjectStatus.*;


/**
 * Convert enum Project Status for table column 'STATUS'
 * 
 * @version 1.0.0 $ 2016-03-26 12:55 $
 */
@Converter( autoApply = true )
public class ProjectStatusConverter implements AttributeConverter< ProjectStatus , Character > {

  
    @Override
    public Character convertToDatabaseColumn( ProjectStatus status ) {
        
        switch ( status ) {
            case STARTED:     return 'S';
            case IN_PROGRESS: return 'P';
            case CLOSED:      return 'C';
            
            default:
                throw new IllegalArgumentException( "Unknow Project status: " + status );
        }
        
    }

    @Override
    public ProjectStatus convertToEntityAttribute( Character dbChar ) {
        
        switch ( dbChar ) {
            case 'S': return STARTED;
            case 'P': return IN_PROGRESS;
            case 'C': return CLOSED;
            
            default:
                throw new IllegalArgumentException( "Unknow Project status: " + dbChar );
        }
        
    }  
  
  
} //:~
