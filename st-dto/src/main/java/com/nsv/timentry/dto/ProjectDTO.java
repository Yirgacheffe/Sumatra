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
    private final Integer   id;
    private final String    projNum;
    private final String    name;

    private final Date      startDate;
    private final Date      closeDate;
    private final boolean   isProj;
    private final int       budget;
    private final char      status;
    private final String    memo;

    private final short     creatorId;
    private final short     lastUpdatedBy;
    private final Date      tsCreated;
    private final Date      tsUpdated;

    // Project leader information, simple id and name
    private final Short     leaderId;
    private final String    leaderName;


    private ProjectDTO( Builder builder ) {
        this.projNum       = builder.projNum;
        this.id            = builder.id;
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
        this.leaderId      = builder.leaderId;
        this.leaderName    = builder.leaderName;
    }

    public boolean isProj()        { return this.isProj;        }
    public Date    closeDate()     { return this.closeDate;     }
    public String  name()          { return this.name;          }
    public Integer id()            { return this.id;            }
    public Short   leaderId()      { return this.leaderId;      }
    public String  leaderName()    { return this.leaderName;    }
    public String  projNum()       { return this.projNum;       }
    public Date    startDate()     { return this.startDate;     }
    public int     budget()        { return this.budget;        }
    public char    status()        { return this.status;        }
    public String  memo()          { return this.memo;          }
    public short   lastUpdatedBy() { return this.lastUpdatedBy; }
    public Date    tsCreated()     { return this.tsCreated;     }
    public Date    tsUpdated()     { return this.tsUpdated;     }

    public Object[] asArrayInDBOrder() {
        return new Object[] {
            projNum,
            name,
            startDate,
            closeDate,
            leaderId,
            isProj, budget, status, memo, creatorId, lastUpdatedBy };
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

        private short    creatorId;
        private short    lastUpdatedBy;
        private Date     tsCreated;
        private Date     tsUpdated;
        private Short    leaderId;
        private String   leaderName;

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

        public Builder creatorId( short creatorId ) {
            this.creatorId = creatorId;
            return this;
        }

        public Builder lastUpdatedBy( short lastUpdatedBy ) {
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

        public Builder leaderId( Short leaderId ) {
            this.leaderId = leaderId;
            return this;
        }

        public Builder leaderName( String leaderName ) {
            this.leaderName = leaderName;
            return this;
        }

    }
    // ----------------------------------------------------------------------------------


} //:~
