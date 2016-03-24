//: com.nsv.timentry.entity: DayLog.java
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
 * Entity class mapping to table 'DAY_LOGS'
 * 
 * @version 1.0.0 $ 2016-03-24 16:43 $
 */
@Entity
@Table( name = "DAY_LOGS" )
public class DayLog implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private int     weekLog;
    private Date    workDay;
    
    private short   empId;
    private String  status;
    
    private short   hours;
    private short   meal;
    private short   version;
    
    
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Integer getId() {
        return this.id;
    }
    
    public void setId( Integer id ) {
        this.id = id;
    }
    
    @Column( name = "WEEK_LOG", nullable = false )
    @NotNull
    public int getWeekLog() {
        return this.weekLog;
    }
    
    public void setWeekLog( int weekLog ) {
        this.weekLog = weekLog;
    }
    
    @Column( name = "WORK_DAY", nullable = false )
    @NotNull
    @Temporal(TemporalType.DATE)
    public Date getWorkDay() {
        return this.workDay;
    }
    
    public void setWorkDay( Date workDay ) {
        this.workDay = workDay;
    }
    
    @Column( name = "EMP_ID", nullable = false )
    @NotNull
    public short getEmpId() {
        return this.empId;
    }
    
    public void setEmpId( short empId ) {
        this.empId = empId;
    }
    
    @Column( name = "STATUS", nullable = false )
    @NotNull
    @Size(min = 1, max = 2)
    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
    
    @Column( name = "HOURS", nullable = false )
    @NotNull
    public short getHours() {
        return hours;
    }

    public void setHours( short hours ) {
        this.hours = hours;
    }

    @Column( name = "MEAL", nullable = false )
    @NotNull
    public short getMeal() {
        return meal;
    }

    public void setMeal( short meal ) {
        this.meal = meal;
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
        return "com.nsv.timentry.persistence.DayLog[ id=" + id + " ]";
    }
    
    
} //:~
