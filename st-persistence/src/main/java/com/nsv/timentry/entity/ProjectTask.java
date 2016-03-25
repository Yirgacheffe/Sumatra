//: com.nsv.timentry.entity: ProjectTask.java
package com.nsv.timentry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.Version;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'PROJ_TASKS'
 * 
 * @version 1.0.0 $ 2016-03-24 13:15 $
 */
@Entity
@Table( name = "PROJ_TASKS" )
public final class ProjectTask implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer id;
    private int     projId;
    private String  name;
    private boolean isExtenal;
    
    private Date    startDate;
    private Date    closeDate;
    private int     estimation;
    private short   phaseId;
    
    private String  memo;
    private int     creatorId;
    private int     lastUpdatedBy;
    
    private Date    tsCreated;
    private Date    tsUpdated;
    
    private short   version;
    
    
    // ------------------------------------------------------------------------
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Integer getId() {
        return this.id;
    }
    
    public void setId( Integer id ) {
        this.id = id;
    }
    
    @Column( name = "PROJ_ID", nullable = false )
    @NotNull
    public int getProjId() {
        return this.projId;
    }

    public void setProjId( int projId ) {
        this.projId = projId;
    }
    
    @Column( name = "NAME", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    @Column( name = "IS_EXTENAL", nullable = false )
    @NotNull
    public boolean isExtenal() {
        return this.isExtenal;
    }

    public void setExtenal( boolean isExtenal ) {
        this.isExtenal = isExtenal;
    }
    
    @Column( name = "START_DATE", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }
    
    @Column( name = "CLOSE_DATE", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getCloseDate() {
        return this.closeDate;
    }
    
    public void setCloseDate( Date closeDate ) {
        this.closeDate = closeDate;
    }
    
    @Column( name = "ESTIMATION", nullable = false )
    @NotNull
    public int getEstimation() {
        return this.estimation;
    }

    public void setEstimation( int estimation ) {
        this.estimation = estimation;
    }
    
    @Column( name = "PHASE_ID", nullable = false )
    @NotNull
    public short getPhaseId() {
        return this.phaseId;
    }

    public void setPhaseId( short phaseId ) {
        this.phaseId = phaseId;
    }
    
    @Column( name = "MEMO", nullable = false, length = 200 )
    @NotNull
    @Size( min = 1, max = 200 )
    public String getMemo() {
        return this.memo;
    }

    public void setMemo( String memo ) {
        this.memo = memo;
    }
    
    @Column( name = "CREATOR_ID", nullable = false )
    @NotNull
    public int getCreatorId() {
        return this.creatorId;
    }

    public void setCreatorId( int creatorId ) {
        this.creatorId = creatorId;
    }
    
    @Column( name = "LAST_UPDATED_BY", nullable = false )
    @NotNull
    public int getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy( int lastUpdatedBy ) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    
    @Column( name = "TS_CREATED", nullable = false )
    @NotNull
    @Temporal( TemporalType.TIMESTAMP )
    public Date getTsCreated() {
        return this.tsCreated;
    }

    public void setTsCreated( Date tsCreated ) {
        this.tsCreated = tsCreated;
    }
    
    @Column( name = "TS_UPDATED", nullable = false )
    @NotNull
    @Temporal( TemporalType.TIMESTAMP )
    public Date getTsUpdated() {
        return this.tsUpdated;
    }

    public void setTsUpdated( Date tsUpdated ) {
        this.tsUpdated = tsUpdated;
    }
    
    @Column( name = "VERSION", nullable = false )
    @NotNull
    @Version
    public short getVersion() {
        return this.version;
    }
    
    public void setVersion( short version ) {
        this.version = version;
    }
    

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.ProjectTask[ id=" + id + " ]";
    }
    
    
} //:~
