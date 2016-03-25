//: com.nsv.timentry.entity: WeekLog.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;


/**
 * Entity class mapping to table 'WEEK_LOGS'
 * 
 * @version 1.0.0 $ 2016-03-24 15:12 $
 */
@Entity
@Table( name = "WEEK_LOGS" )
public final class WeekLog implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer id;
    
    private short   empId;
    private short   year;
    private short   week;
    private String  status;
    
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
    
    @Column( name = "EMP_ID", nullable = false )
    @NotNull
    public short getEmpId() {
        return this.empId;
    }

    public void setEmpId( short empId ) {
        this.empId = empId;
    }
    
    @Column( name = "YEAR", nullable = false )
    @NotNull
    public short getYear() {
        return this.year;
    }

    public void setYear( short year ) {
        this.year = year;
    }

    @Column( name = "WEEK", nullable = false )
    @NotNull
    public short getWeek() {
        return this.week;
    }

    public void setWeek( short week ) {
        this.week = week;
    }

    @Column( name = "STATUS", nullable = false )
    @NotNull
    @Size( min = 1, max = 2 )
    public String getStatus() {
        return this.status;
    }

    public void setStatus( String status ) {
        this.status = status;
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
        return "com.nsv.timentry.persistence.WeekLog[ id=" + id + " ]";
    }
    
    
} //:~
