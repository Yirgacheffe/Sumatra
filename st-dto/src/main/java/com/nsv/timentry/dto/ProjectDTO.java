//: com.nsv.timentry.dto: ProjectDTO.java
package com.nsv.timentry.dto;

import java.util.Date;
import java.io.Serializable;


/**
 * ProjectDTO connect present layer and service layer, mapped field for table 'PROJECTS'
 *
 * @version 1.0.0 $ 2016-04-16 14:07 $
 */
public final class ProjectDTO implements Serializable {


    private static final long serialVersionUID = 6825287309909265273L;

    // ----------------------------------------------------------------------------------
    private final Integer id;
    private final String  projNum;
    private final String  name;

    private final Date    startDate;
    private final Date    closeDate;
    private final boolean isProj;
    private final int     budget;
    private final char    status;
    private final String  memo;

    private final int     creatorId;
    private final int     lastUpdatedBy;
    private final Date    tsCreated;
    private final Date    tsUpdated;


    private ProjectDTO( Builder builder ) {
        this.id            = builder.id;
        this.projNum       = builder.projNum;
        this.name          = builder.name;
        this.startDate     = builder.startDate;
        this.closeDate     = builder.closeDate;
        this.isProj        = builder.isProj;
        this.budget        = builder.budget;
        this.status        = builder.status;
        this.memo          = builder.memo;
        this.creatorId     = builder.creatorId;
        this.lastUpdatedBy = builder.lastUpdatedBy;
        this.tsCreated     = builder.tsCreated;
        this.tsUpdated     = builder.tsUpdated;
    }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
                projNum,
                name,
                startDate,
                closeDate, isProj, budget, status, memo, creatorId, lastUpdatedBy };
    }

    // ----------------------------------------------------------------------------------
    public static class Builder {

        private Integer  id;
        private String   projNum;
        private String   name;

        private Date     startDate;
        private Date     closeDate;
        private boolean  isProj;
        private int      budget;
        private char     status;
        private String   memo;

        private int      creatorId;
        private int      lastUpdatedBy;
        private Date     tsCreated;
        private Date     tsUpdated;

        public Builder() {
            // Keep this as default
        }

        // Call private constructor to create DTO
        public ProjectDTO build() {
            return new ProjectDTO( this );
        }

        public Builder projNum( String projNum ) {
            this.projNum = projNum;
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

        public Builder budget( int budget ) {
            this.budget = budget;
            return this;
        }

        public Builder isProj( boolean isProj ) {
            this.isProj = isProj;
            return this;
        }

        public Builder status( char status ) {
            this.status = status;
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
