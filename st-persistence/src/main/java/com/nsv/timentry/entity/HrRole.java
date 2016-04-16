//: com.nsv.timentry.entity: HrRole.java
package com.nsv.timentry.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Version;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;


/**
 * Entity class mapping to table 'HR_ROLES'
 * 
 * @version 1.0.0 $ 2016-03-25 19:14 $
 */
@Entity
@Table( name = "HR_ROLES" )
public final class HrRole implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Short   id;
    
    private String  name;
    private boolean isTVs;
    private boolean isRemoved;
    
    private String  memo;
    private short   version;
    
    
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Short getId() {
        return this.id;
    }
    
    public void setId( Short id ) {
        this.id = id;
    }

    @Column( name = "NAME", nullable = false, length = 50 )
    @NotNull
    @Size(min = 1, max = 50)
    public String getName() {
        return this.name;
    }

    public void setName( String name ) {
        this.name = name;
    }
    
    @Column( name = "IS_TVs", nullable = false )
    @NotNull
    public boolean isTVs() {
        return this.isTVs;
    }

    public void setTVs( boolean isTVs ) {
        this.isTVs = isTVs;
    }
    
    @Column( name = "IS_REMOVED", nullable = false )
    @NotNull
    public boolean isRemoved() {
        return isRemoved;
    }

    public void setRemoved( boolean isRemoved ) {
        this.isRemoved = isRemoved;
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
        return "com.nsv.timentry.persistence.HrRole[ id=" + id + " ]";
    }
    
} //:~
