//: com.nsv.timentry.dto: TaskDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * TaskDTO connect present layer and service layer, mapped field for table 'TASKS'
 *
 * @version 1.0.0 $ 2016-04-16 14:55 $
 */
public final class TaskDTO implements Serializable {


    private static final long serialVersionUID = -8678393451269198564L;

    // ----------------------------------------------------------------------------------
    private Integer id;

    private boolean isExtenal;
    private String  name;
    private Date    startDate;
    private Date    closeDate;
    private int     estimation;

    private int     creatorId;
    private String  memo;
    private int     lastUpdatedBy;
    private Date    tsCreated;
    private Date    tsUpdated;
    private int     projId;
    private Short   phaseId;


    private TaskDTO( Builder builder ) {

        this.id            = builder.id;
        this.isExtenal     = builder.isExtenal;
        this.name          = builder.name;
        this.startDate     = builder.startDate;
        this.closeDate     = builder.closeDate;
        this.estimation    = builder.estimation;
        this.projId        = builder.projId;
        this.phaseId       = builder.phaseId;
        this.memo          = builder.memo;
        this.creatorId     = builder.creatorId;
        this.lastUpdatedBy = builder.lastUpdatedBy;
        this.tsCreated     = builder.tsCreated;
        this.tsUpdated     = builder.tsUpdated;
    }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
                projId,
                name,
                isExtenal,
                startDate,
                closeDate, estimation, phaseId, memo, creatorId, lastUpdatedBy };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Integer id;

        private boolean isExtenal;
        private String  name;
        private Date    startDate;
        private Date    closeDate;
        private int     estimation;

        private int     creatorId;
        private String  memo;
        private int     lastUpdatedBy;
        private Date    tsCreated;
        private Date    tsUpdated;
        private int     projId;
        private Short   phaseId;

        public Builder() {
            // Keep this as default
        }

        // Call private constructor to create DTO
        public TaskDTO build() {
            return new TaskDTO( this );
        }

        public Builder isExtenal( boolean isExtenal ) {
            this.isExtenal = isExtenal;
            return this;
        }

        public Builder id( Integer id ) {
            this.id = id;
            return this;
        }

        public Builder name( String name ) {
            this.name = name;
            return this;
        }

        public Builder startDate( Date startDate ) {
            this.startDate = startDate;
            return this;
        }

        public Builder closeDate( Date closeDate ) {
            this.closeDate = closeDate;
            return this;
        }

        public Builder estimation( int estimation ) {
            this.estimation = estimation;
            return this;
        }

        public Builder projId( int projId ) {
            this.projId = projId;
            return this;
        }

        public Builder phaseId( short phaseId ) {
            this.phaseId = phaseId;
            return this;
        }

        public Builder memo( String memo ) {
            this.memo = memo;
            return this;
        }

        public Builder creatorId( int creatorId ) {
            this.creatorId = creatorId;
            return this;
        }

        public Builder lastUpdatedBy( int lastUpdatedBy ) {
            this.lastUpdatedBy = lastUpdatedBy;
            return this;
        }

        public Builder tsCreated( Date tsCreated ) {
            this.tsCreated = tsCreated;
            return this;
        }

        public Builder tsUpdated( Date tsUpdated ) {
            this.tsUpdated = tsUpdated;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
