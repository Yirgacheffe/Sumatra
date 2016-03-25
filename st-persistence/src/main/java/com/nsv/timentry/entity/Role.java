//: com.nsv.timentry.entity: Role.java
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
 * Entity class mapping to table 'ROLES'
 * 
 * @version 1.0.0 $ 2016-03-24 14:43 $
 */
@Entity
@Table( name = "ROLES" )
public final class Role implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    
    private Short   id;
    
    private String  type;
    private String  name;
    private boolean isRemoved;
    
    private String  memo;
    private short   version;
    

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
    
    @Column( name = "TYPE", nullable = false )
    @NotNull
    @Size( min = 1, max = 2 )
    public String getType() {
        return this.type;
    }

    public void setType( String type ) {
        this.type = type;
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
    
    @Column( name = "IS_REMOVED", nullable = false )
    @NotNull
    public boolean getIsRemoved() {
        return this.isRemoved;
    }

    public void setIsRemoved( boolean isRemoved ) {
        this.isRemoved = isRemoved;
    }

    @Column( name = "MEMO", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
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
        return "com.nsv.timentry.persistence.Role[ id=" + id + " ]";
    }
    
    
} //:~
