//: com.nsv.timentry.entity: ProjectLogs.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'PROJ_LOGS'
 * 
 * @version 1.0.0 $ 2016-03-24 11:14 $
 */
@Entity
@Table( name = "PROJ_LOGS" )
public final class ProjectLog implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer id;
    
    private int dayLog;
    private int itemId;
    private int projId;
    private int taskId;
    
    
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
    
    @Column( name = "DAY_LOG", nullable = false )
    @NotNull
    public int getDayLog() {
        return this.dayLog;
    }

    public void setDayLog( int dayLog ) {
        this.dayLog = dayLog;
    }
    
    @Column( name = "ITEM_ID", nullable = false )
    @NotNull
    public int getItemId() {
        return this.itemId;
    }

    public void setItemId( int itemId ) {
        this.itemId = itemId;
    }
    
    @Column( name = "PROJ_ID", nullable = false )
    @NotNull
    public int getProjId() {
        return this.projId;
    }

    public void setProjId( int projId ) {
        this.projId = projId;
    }
    
    @Column( name = "TASK_ID", nullable = false )
    @NotNull
    public int getTaskId() {
        return this.taskId;
    }

    public void setTaskId( int taskId ) {
        this.taskId = taskId;
    }
    
    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.ProjectLog[ id=" + id + " ]";
    }
    
    
} //:~
