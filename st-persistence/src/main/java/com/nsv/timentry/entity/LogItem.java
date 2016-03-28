//: com.nsv.timentry.entity: LogItem.java
package com.nsv.timentry.entity;

import com.nsv.timentry.constant.LogType;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'LOG_ITEMS'
 * 
 * @version 1.0.0 $ 2016-03-24 09:30 $
 */
@Entity
@Table( name = "LOG_ITEMS" )
public final class LogItem implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer   id;
    private LogType   type;
    private String    content;
    private short     hours;
    
    private Date      startOn;
    private Date      closeOn;
    private Character place;
    private DayLog    dayLog;
    private Project   project;
    private Task      task;
    
    
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
    
    @Column( name = "TYPE", nullable = false )
    @NotNull
    public LogType getType() {
        return this.type;
    }

    public void setType( LogType type ) {
        this.type = type;
    }
    
    @Column( name = "CONTENT", nullable = false, length = 300 )
    @NotNull
    @Size( min = 1, max = 300 )
    public String getContent() {
        return this.content;
    }

    public void setContent( String content ) {
        this.content = content;
    }
    
    @Column( name = "HOURS", nullable = false )
    @NotNull
    public short getHours() {
        return this.hours;
    }

    public void setHours( short hours ) {
        this.hours = hours;
    }
    
    @Column( name = "START_ON", nullable = true )
    @Temporal( TemporalType.TIME )
    public Date getStartOn() {
        return this.startOn;
    }

    public void setStartOn( Date startOn ) {
        this.startOn = startOn;
    }

    @Column( name = "CLOSE_ON", nullable = true )
    @Temporal( TemporalType.TIME )
    public Date getCloseOn() {
        return closeOn;
    }

    public void setCloseOn( Date closeOn ) {
        this.closeOn = closeOn;
    }
    
    @Column( name = "PLACE",    nullable = true )
    public Character getPlace() {
        return this.place;
    }

    public void setPlace( Character place ) {
        this.place = place;
    }
    
    // ------------------------------------------------------------------------
    @ManyToOne
    @JoinColumn( name = "DAY_LOG", nullable = false )
    public DayLog getDayLog() {
        return this.dayLog;
    }

    public void setDayLog( DayLog dayLog ) {
        this.dayLog = dayLog;
    }
    
    @ManyToOne
    @JoinColumn( name = "PROJ_ID", nullable = false )
    public Project getProject() {
        return this.project;
    }

    public void setProject( Project project ) {
        this.project = project;
    }
    
    @ManyToOne
    @JoinColumn( name = "TASK_ID", nullable = true  )
    public Task getTask() {
        return this.task;
    }

    public void setTask( Task task ) {
        this.task = task;
    }


    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.LogItem[ id=" + id + " ]";
    }
    
    
} //:~
