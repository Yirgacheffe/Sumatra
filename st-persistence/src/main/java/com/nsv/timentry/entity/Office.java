//: com.nsv.timentry.entity: Office.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;


/**
 * Entity class mapping to table 'OFFICES'
 * 
 * @version 1.0.0 $ 2016-03-24 10:15 $
 */
@Entity
@Table( name = "OFFICES" )
public final class Office implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Short   id;
    private String  address;
    private String  name;
    
    private short   workingHours;
    private boolean isUsed;
    
    private String  memo;
    
    
    // ------------------------------------------------------------------------
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Short getId() {
        return this.id;
    }
    
    public void setId( Short id ) {
        this.id = id;
    }
    
    @Column( name = "ADDRESS", nullable = false, length = 150 )
    @NotNull
    @Size( min = 1, max = 150 )
    public String getAddress() {
        return this.address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }
    
    @Column( name = "NAME", nullable = false, length = 30 )
    @NotNull
    @Size( min = 1, max = 30 )
    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    @Column( name = "WORKING_HOURS", nullable = false )
    @NotNull
    public short getWorkingHours() {
        return this.workingHours;
    }

    public void setWorkingHours( short workingHours ) {
        this.workingHours = workingHours;
    }
    
    @Column( name = "IS_INUSE", nullable = false )
    @NotNull
    public boolean isUsed() {
        return this.isUsed;
    }

    public void setUsed( boolean isUsed ) {
        this.isUsed = isUsed;
    }
    
    @Column( name = "MEMO", nullable = true, length = 100 )
    @Size( max = 100 )
    @Basic( fetch = LAZY )
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo( String memo ) {
        this.memo = memo;
    }
    

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Office[ id=" + id + " ]";
    }
    
} //:~
