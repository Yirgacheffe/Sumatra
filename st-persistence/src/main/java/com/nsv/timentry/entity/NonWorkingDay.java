// com.nsv.timentry.entity: NonWorkingDay.java
package com.nsv.timentry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
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
import static javax.persistence.FetchType.LAZY;


/**
 * Entity class mapping to table 'NON_WORKINGDAY'
 * 
 * @version 1.0.0 $ 2016-03-24 19:01 $
 */
@Entity
@Table( name = "NON_WORKINGDAY" )
public final class NonWorkingDay implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Integer id;
    
    private Date    holidayDate;
    private String  name;
    private Day     type;
    private short   week;
    
    private String  memo;
    private short   version;
    
    
    // ----------------------------------------------------------------
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    @Column( name = "HOLI_DATE", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getHolidayDate() {
        return holidayDate;
    }

    public void setHolidayDate( Date holidayDate ) {
        this.holidayDate = holidayDate;
    }

    @Column( name = "NAME", nullable = false, length = 20 )
    @NotNull
    @Size(min = 1, max = 20)
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Column( name = "TYPE", nullable = false )
    @NotNull
    public Day getType() {
        return type;
    }

    public void setType( Day type ) {
        this.type = type;
    }

    @Column( name = "WEEK", nullable = false )
    @NotNull
    public short getWeek() {
        return week;
    }

    public void setWeek( short week ) {
        this.week = week;
    }
    
    @Column( name = "MEMO", nullable = true, length = 150 )
    @Size( max = 150 )
    @Basic( fetch = LAZY )
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo( String memo ) {
        this.memo = memo;
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
        return "com.nsv.timentry.persistence.Holiday[ id=" + id + " ]";
    }
    
    
} //:~
