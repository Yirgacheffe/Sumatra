//: com.nsv.timentry.dto: DayLogDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * DayLogDTO connect present layer and service layer, mapped field for table 'DAY_LOGS'
 *
 * @version 1.0.0 $ 2016-04-15 23:19 $
 */
public final class DayLogDTO implements Serializable {


    private static final long serialVersionUID = 8043842419270323332L;

    // ----------------------------------------------------------------------------------
    private final Integer id;
    private final Date    workDay;
    private final Short   empId;
    private final Integer weekLog;

    private final char    status;
    private final Short   workHrs;
    private final Short   meal;

    private DayLogDTO( Builder builder ) {
        this.id      = builder.id;
        this.workDay = builder.workDay;
        this.empId   = builder.empId;
        this.weekLog = builder.weekLog;
        this.status  = builder.status;
        this.workHrs = builder.workHrs;
        this.meal    = builder.meal;
    }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
                workDay, empId, weekLog, status, workHrs, meal };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Integer id;
        private Date    workDay;
        private Short   empId;
        private Integer weekLog;

        private char    status;
        private Short   workHrs;
        private Short   meal;

        public Builder() {
            // Keep this...
        }

        public DayLogDTO build() {
            return new DayLogDTO( this );
        }

        public Builder id( Integer id ) {
            this.id = id;
            return this;
        }

        public Builder workDay( Date workDay ) {
            this.workDay = workDay;
            return this;
        }

        public Builder empId( Short empId ) {
            this.empId = empId;
            return this;
        }

        public Builder meal( Short meal ) {
            this.meal = meal;
            return this;
        }

        public Builder weekLog( Integer weekLog ) {
            this.weekLog = weekLog;
            return this;
        }

        public Builder status( char status ) {
            this.status = status;
            return this;
        }

        public Builder workHrs( Short workHrs ) {
            this.workHrs = workHrs;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
