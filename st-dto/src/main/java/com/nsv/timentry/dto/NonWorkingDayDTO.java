//: com.nsv.timentry.dto: NonWorkingDayDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * NonWorkingDayDTO connect present layer and service layer, mapped field for table 'NON_WORKINGDAY'
 *
 * @version 1.0.0 $ 2016-04-16 01:40 $
 */
public final class NonWorkingDayDTO implements Serializable {


    private static final long serialVersionUID = 8043842419270323332L;

    // ----------------------------------------------------------------------------------
    private Integer id;

    private Date    holidayDate;
    private String  name;
    private char    type;
    private short   week;
    private String  memo;

    private NonWorkingDayDTO( Builder builder ) {
        this.id   = builder.id;
        this.name = builder.name;
        this.type = builder.type;
        this.week = builder.week;
        this.memo = builder.memo;
        this.holidayDate = builder.holidayDate;
    }

    public Object[] asArrayInDBOrder() {
        return new Object[] { holidayDate, name, type, week, memo };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Integer id;

        private Date    holidayDate;
        private String  name;
        private char    type;
        private short   week;
        private String  memo;

        public Builder() {
            // Keep this...
        }

        public NonWorkingDayDTO build() {
            return new NonWorkingDayDTO( this );
        }

        public Builder id( Integer id ) {
            this.id = id;
            return this;
        }

        public Builder holidayDate( Date holidayDate ) {
            this.holidayDate = holidayDate;
            return this;
        }

        public Builder name( String name ) {
            this.name = name;
            return this;
        }

        public Builder week( Short week ) {
            this.week = week;
            return this;
        }

        public Builder type( char type ) {
            this.type = type;
            return this;
        }

        public Builder memo( String memo ) {
            this.memo = memo;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
