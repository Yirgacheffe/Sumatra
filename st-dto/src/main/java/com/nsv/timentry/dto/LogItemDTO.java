//: com.nsv.timentry.dto: LogItemDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * LogItemDTO connect present layer and service layer, mapped field for table 'LOG_ITEMS'
 *
 * @version 1.0.0 $ 2016-04-16 01:19 $
 */
public final class LogItemDTO implements Serializable {


    private static final long serialVersionUID = 3844405094203131645L;

    // ----------------------------------------------------------------------------------
    private final Integer id;

    private final Integer dayLog;
    private final Integer projId;
    private final Integer taskId;

    private final char    type;
    private final String  content;
    private final Short   workHrs;
    private final Date    startOn;
    private final Date    closeOn;
    private final char    place;

    private LogItemDTO( Builder builder ) {
        this.id      = builder.id;
        this.dayLog  = builder.dayLog;
        this.projId  = builder.projId;
        this.taskId  = builder.taskId;
        this.type    = builder.type;
        this.content = builder.content;
        this.workHrs = builder.workHrs;
        this.startOn = builder.startOn;
        this.closeOn = builder.closeOn;
        this.place   = builder.place;
    }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
                dayLog, projId, taskId, type, content, workHrs, startOn, closeOn, place };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Integer id;
        private Integer dayLog;
        private Integer projId;
        private Integer taskId;

        private char    type;
        private String  content;
        private Short   workHrs;
        private Date    startOn;
        private Date    closeOn;
        private char    place;

        public Builder() {
            // Keep this...
        }

        public LogItemDTO build() {
            return new LogItemDTO( this );
        }

        public Builder id( Integer id ) {
            this.id = id;
            return this;
        }

        public Builder dayLog( Integer dayLog ) {
            this.dayLog = dayLog;
            return this;
        }

        public Builder projId( Integer projId ) {
            this.projId = projId;
            return this;
        }

        public Builder taskId( Integer taskId ) {
            this.taskId = taskId;
            return this;
        }

        public Builder type( char type ) {
            this.type = type;
            return this;
        }

        public Builder workHrs( Short workHrs ) {
            this.workHrs = workHrs;
            return this;
        }

        public Builder startOn( Date startOn ) {
            this.startOn = startOn;
            return this;
        }

        public Builder closeOn( Date closeOn ) {
            this.closeOn = closeOn;
            return this;
        }

        public Builder place( char place ) {
            this.place = place;
            return this;
        }

        public Builder content( String content ) {
            this.content = content;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
