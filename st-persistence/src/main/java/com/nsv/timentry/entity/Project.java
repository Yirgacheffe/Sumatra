//: com.nsv.timentry.entity: Project.java
package com.nsv.timentry.entity;

import java.util.Collection;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;

import com.nsv.timentry.constant.ProjectStatus;


/**
 * Entity class mapping to table 'PROJECTS'
 * 
 * @version 1.0.0 $ 2016-03-24 13:08 $
 */
@Entity
@Table( name = "PROJECTS" )
public final class Project implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer       id;
    private String        projNum;
    private String        name;
    
    private Date          startDate;
    private Date          closeDate;
    private boolean       isProj;
    private int           budget;
    private ProjectStatus status;
    private String        memo;
    
    private int           creatorId;
    private int           lastUpdatedBy;
    private Date          tsCreated;
    private Date          tsUpdated;
    private short         version;
    
    private Collection<Task>     tasks;
    private Collection<Employee> projMembers;
    
    
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

    @Column( name = "PROJ_NUM", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getProjNum() {
        return projNum;
    }

    public void setProjNum( String projNum ) {
        this.projNum = projNum;
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
    
    @Column( name = "START_DATE", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }
    
    @Column( name = "CLOSE_DATE", nullable = true )
    @Temporal( TemporalType.DATE )
    public Date getCloseDate() {
        return this.closeDate;
    }

    public void setCloseDate( Date closeDate ) {
        this.closeDate = closeDate;
    }
    
    @Column( name = "IS_PROJ", nullable = false )
    @NotNull
    public boolean isProj() {
        return isProj;
    }

    public void setProj( boolean isProj ) {
        this.isProj = isProj;
    }
    
    @Column( name = "BUDGET", nullable = false )
    @NotNull
    public int getBudget() {
        return this.budget;
    }

    public void setBudget( int budget ) {
        this.budget = budget;
    }

    @Column( name = "STATUS", nullable = false )
    @NotNull
    public ProjectStatus getStatus() {
        return this.status;
    }

    public void setStatus( ProjectStatus status ) {
        this.status = status;
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
    
    @Column( name = "TS_CREATED", nullable = false )
    @NotNull
    @Temporal( TemporalType.TIMESTAMP )
    public Date getTsCreated() {
        return this.tsCreated;
    }

    public void setTsCreated( Date tsCreated ) {
        this.tsCreated = tsCreated;
    }
    
    @Column( name = "LAST_UPDATED_BY", nullable = false )
    @NotNull
    public int getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy( int lastUpdatedBy ) {
        this.lastUpdatedBy = lastUpdatedBy;
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
    
    // ------------------------------------------------------------------------
    @OneToMany( mappedBy = "project", fetch = LAZY )
    public Collection<Task> getTasks() {
        return this.tasks;
    }
    
    public void setTasks( Collection<Task> tasks ) {
        this.tasks = tasks;
    }
    
    @ManyToMany
    @JoinTable( name = "PROJ_EMPS", 
        joinColumns        = @JoinColumn( name = "PROJ_ID" ),
        inverseJoinColumns = @JoinColumn( name = "EMP_ID"  )
    )
    public Collection<Employee> getProjMembers() {
        return this.projMembers;
    }
    
    public void setProjMembers( Collection<Employee> projMembers ) {
        this.projMembers = projMembers;
    }
    

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Project[ id=" + id + " ]";
    }
    
    
} //:~
