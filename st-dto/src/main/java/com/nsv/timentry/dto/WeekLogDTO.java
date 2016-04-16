//: com.nsv.timentry.dto: WeekLogDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * WeekLogDTO connect present layer and service layer, mapped field for table 'WEEK_LOGS'
 *
 * @version 1.0.0 $ 2016-04-16 15:00 $
 */
public final class WeekLogDTO implements Serializable {


    private static final long serialVersionUID = -8678393451269198564L;

    // ----------------------------------------------------------------------------------
    private final Integer id;
    private final short   empId;
    private final short   year;
    private final short   week;
    private final char    status;

    private WeekLogDTO( Builder builder ) {

        this.id     = builder.id;
        this.empId  = builder.empId;
        this.year   = builder.year;
        this.week   = builder.week;
        this.status = builder.status;
    }

    public Object[] asArrayInDBOrder() {
        return new Object[] { empId, year, week, status };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Integer id;
        private short   empId;
        private short   year;
        private short   week;
        private char    status;

        public Builder() {
            // Keep this as default
        }

        // Call private constructor to create DTO
        public WeekLogDTO build() {
            return new WeekLogDTO( this );
        }

        public Builder id( Integer id ) {
            this.id = id;
            return this;
        }

        public Builder empId( short empId ) {
            this.empId = empId;
            return this;
        }

        public Builder year( short year ) {
            this.year = year;
            return this;
        }

        public Builder week( short week ) {
            this.week = week;
            return this;
        }

        public Builder status( char status ) {
            this.status = status;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
